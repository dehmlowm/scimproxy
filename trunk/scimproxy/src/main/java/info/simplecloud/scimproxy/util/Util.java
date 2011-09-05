package info.simplecloud.scimproxy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Util methods that's used by ScimProxy.
 */
public class Util {

	private static SecureRandom random = new SecureRandom();

	/**
	 * Generates a pseudo random string that can be used as a version string in
	 * a SCIM user.
	 * 
	 * @return A pseudo random string.
	 */
	public static String generateVersionString() {
		return new BigInteger(130, random).toString(32) + Long.toString(System.currentTimeMillis());
	}


    /**
     * Gets the content from a request by looping though all lines.
     * 
     * @param req
     *            The request to parse.
     * @return The content of the request or null if an error occurred while
     *         parsing request.
     */
    public static String getContent(HttpServletRequest req) {
        String query = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
            String message = null;
            while ((message = reader.readLine()) != null) {
                query += message;
            }
        } catch (IOException e) {
            query = null;
        }
        return query;
    }

    /**
     * Gets an user id from a request. /User/myuserid will return myuserid.
     * 
     * @param query
     *            A URI, for example /User/myuserid.
     * @return A scim user id.
     */
    public static String getUserIdFromUri(String query) {
        String id = "";
        // TODO: add more validation of input
        String s = "/User/";
        if (query != null && query.length() > 0) {
            int indexOfUserId = query.indexOf(s) + s.length();

            id = query.substring(indexOfUserId);
            try {
                id = URLDecoder.decode(id, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // just return empty id
            }
        }
        return id;
    }


    /**
     * Gets an group id from a request. /Group/myGroupId will return myGroupId.
     * 
     * @param query
     *            A URI, for example /Group/myuserid.
     * @return A scim group id.
     */
    public static String getGroupIdFromUri(String query) {
        String id = "";
        // TODO: add more validation of input
        String s = "/Group/";
        if (query != null && query.length() > 0) {
            int indexOfUserId = query.indexOf(s) + s.length();

            id = query.substring(indexOfUserId);
            try {
                id = URLDecoder.decode(id, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                // just return empty id
            }
        }
        return id;
    }
    
    public static List<String> getAttributeStringFromRequest(HttpServletRequest req) {
        String attributesString = req.getParameter("attributes") == null ? "" : req.getParameter("attributes");
        List<String> attributesList = new ArrayList<String>();
        if (attributesString != null && !"".equals(attributesString)) {
            for (String attribute : attributesString.split(",")) {
                attributesList.add(attribute.trim());
            }
        }
        return attributesList;
    }
    
	
	
}