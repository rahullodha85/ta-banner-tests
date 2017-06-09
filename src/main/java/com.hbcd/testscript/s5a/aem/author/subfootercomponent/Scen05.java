package com.hbcd.testscript.s5a.aem.author.subfootercomponent;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;

import com.hbcd.base.ScenarioAEMAuthor;
import com.hbcd.scripting.core.Storage;


public class Scen05 extends ScenarioAEMAuthor {

	@Override
	public void executeScript() throws Exception  {

		javax.jcr.Session session = null;
		Node x = null;
		
		try {

			if (Storage.get("environment").equals("local")) {

			//Create a connection to the CQ repository running on local host
			Repository repository = JcrUtils.getRepository("http://localhost:4502/crx/server");
			//Create a Session
			session = repository.login( new SimpleCredentials("admin", "admin".toCharArray()));
			//Create a node that represents the root node
			Node root = session.getRootNode();
			System.out.println("NAME : " + root.getName());
			x = session.getNode("/content/saks/sanity_test_author/jcr:content/footerpar");
			x.getNode("footer").remove();
			}
			else{
			Repository repository = JcrUtils.getRepository("http://dev-hbc-author1.adobecqms.net:4502/crx/server");				
			//Create a Session
			session = repository.login( new SimpleCredentials("admin", "@W2rhLW>i@Wo9".toCharArray()));
			//Create a node that represents the root node
			Node root = session.getRootNode();
			System.out.println("NAME : " + root.getName());
			x = session.getNode("/content/saks/sanity_test_author/jcr:content/footerpar");
			x.getNode("footer").remove();			
			}

			// http://dev-hbc-author1.adobecqms.net:4502/sites.html/content/saks0/en_us/sanity_test_author
			// http://localhost:4502/crx/de/index.jsp#/content/saks/en_us/sanity_test_author





			Node footer = x.addNode("footer", "nt:unstructured");
			System.out.println("Adding footer");
			footer.setProperty("sling:resourceType", "saks/components/content/Footer");
			
			System.out.println("Adding footer property");
			footer.setProperty("desktopLabel", new String[] {"Customer service", "Email"});
			footer.setProperty("desktopLabel1", new String[] {"Edition", "The trendcaster"});
			footer.setProperty("desktopLabel2", new String[] {"About Us", "Careers"});
			footer.setProperty("desktopLabel3", new String[] {"Domestic", "International"});
			footer.setProperty("desktopLabel4", new String[] {"Saks First", "Upgrade to Saks Master Card"});
			footer.setProperty("heading1", "Shop Saks");
			footer.setProperty("heading2", "Stores & Corporate");
			footer.setProperty("heading3", "Shipping & Returns");
			footer.setProperty("heading4", "Saks First Card");
			footer.setProperty("hideonMobile1", new String[] {"true","true"});
			footer.setProperty("linkUrl", new String[] {"http://www.saksfifthavenue.com/Customer-Service", "http://www.saksfifthavenue.com/main/collection.jsp#"});
			footer.setProperty("linkUrl1", new String[] {"http://www.saksfifthavenue.com/editorial/edit.jsp?pageid=collage?bmUID=kXvesEB", "http://www.saksfifthavenue.com/trendcaster?bmUID=kXvesEC"});
			footer.setProperty("linkUrl2", new String[] {"http://www.saksfifthavenue.com/About-Us", "http://www.careersatsaks.com/"});
			footer.setProperty("linkUrl3", new String[] {"http://www.saksfifthavenue.com/Shipping-Returns-Taxes", "http://www.saksfifthavenue.com/International"});
			footer.setProperty("linkUrl4", new String[] {"http://www.saksfifthavenue.com/SaksFirst", "http://www.saksfifthavenue.com/SaksFirst"});
			footer.setProperty("mobileLabel", new String[] {"", ""});
			footer.setProperty("mobileLabel1", new String[] {"", "The Trendcaster"});
			footer.setProperty("mobileLabel2", new String[] {"", ""});
			footer.setProperty("mobileLabel3", new String[] {"", ""});
			footer.setProperty("mobileLabel4", new String[] {"", ""});
			footer.setProperty("numLinks", "2");
			footer.setProperty("numLinks1", "2");
			footer.setProperty("numLinks2", "2");
			footer.setProperty("numLinks3", "2");
			footer.setProperty("numLinks4", "2");
			footer.setProperty("serviceText", "We’re Dedicated to Our Customers 24/7");
			footer.setProperty("windowType", new String[] {"sameWindow", "newTab"});
			footer.setProperty("windowType1", new String[] {"newWindow", "sameWindow"});
			footer.setProperty("windowType2", new String[] {"sameWindow", "sameWindow"});
			footer.setProperty("windowType3", new String[] {"sameWindow", "sameWindow"});
			footer.setProperty("windowType4", new String[] {"sameWindow", "sameWindow"});
					
			
			// Save the session changes and log out
			System.out.println("complete");
			session.save();
			session.logout();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}