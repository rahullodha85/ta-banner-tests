package com.hbcd.testscript.s5a.aem.author.createpage;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;

import com.hbcd.banner.aem.utility.AuthorUtility;
import com.hbcd.testscript.s5a.aem.author.SaksObjBean;
import org.apache.jackrabbit.commons.JcrUtils;
import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.Report;
import com.hbcd.scripting.core.Storage;


public class deletePageUsingJcrApi extends ScenarioAEMAuthor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void executeScript() throws Exception, javax.jcr.RepositoryException {
		javax.jcr.Session session = null;
		Node x = null;

        SaksObjBean sOB = new SaksObjBean();
        sOB.setEnv(Storage.get("environment"));
        String val = Storage.get("Test_Page_Name");
        System.out.println("got the value of Test Page Name : " + val);

        AuthorUtility.login(Storage.get("username"),Storage.get("password") );

        Thread.sleep(2000);
        AuthorUtility.deletePage(val);
        AuthorUtility.deletePage("test_delete_me");

/*
		try {

		// Create a connection to the CQ repository running on local host
			String Url = Storage.get("url");
			String user = Storage.get("username");
			String pass = Storage.get("password");
			pagename = Storage.get("Sanity_Test_Author");
			
			System.out.println("Vars : " + user + " " + pass + " " + Url);
			String repo = Url.concat("/crx/server");
			//Repository repository =
			// JcrUtils.getRepository("http://localhost:4502/crx/server");
			Repository repository = JcrUtils.getRepository(repo);

			// Create a Session
			session = repository.login(new SimpleCredentials(user, pass.toCharArray()));
			// Create a node that represents the root node
			Node root = session.getRootNode();
			String pageparent = "/content/sof/";
			pageparent = pageparent.concat("Sanity_Test_Author");
			//String pageparent = "/content/saks/sanity_test_authorrf";
			x = session.getNode(pageparent);			
			System.out.println("Nodename : " +x.getName());
			x.remove();
			session.save();
			Report.pass("Deleted page - " + pagename);
			
		} catch (Exception e1) {
			e1.printStackTrace();
			Report.log("Error while executing Script", "Failed",
					"NO screenshots", "");
			Report.fail("Script failed - Could not delete" + pagename, "");
		
		}*/
	}
}
