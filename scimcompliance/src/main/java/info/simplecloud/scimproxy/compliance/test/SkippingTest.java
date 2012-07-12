package info.simplecloud.scimproxy.compliance.test;

import info.simplecloud.scimproxy.compliance.CSP;
import info.simplecloud.scimproxy.compliance.enteties.TestResult;

import java.util.ArrayList;
import java.util.List;

public class SkippingTest extends Test {

	public SkippingTest(CSP csp, ResourceCache<CachedUser> cache, ResourceCache<CachedGroup> groupCache) {
		super(csp, cache, groupCache);
	}

	@Override
	public List<TestResult> run() {
		List<TestResult> results = new ArrayList<TestResult>();
		results.add(new TestResult(TestResult.SKIPPED, "Skipping 1", "Skipping for fun.", "Skip skip"));
		results.add(new TestResult(TestResult.SKIPPED, "Skipping 2", "Skipping for fun.", "Skip skip"));
		results.add(new TestResult(TestResult.SKIPPED, "Skipping 3", "Skipping for fun.", "Skip skip"));
		results.add(new TestResult(TestResult.SKIPPED, "Skipping 4", "Skipping for fun.", "Skip skip"));
		results.add(new TestResult(TestResult.SKIPPED, "Skipping 5", "Skipping for fun.", "Skip skip"));
		results.add(new TestResult(TestResult.SKIPPED, "Skipping 6", "Skipping for fun.", "Skip skip"));
		return results;
	}

}
