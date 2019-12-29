package com.example.demo.model.xml;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Metadata {
	
	// Inner class for link propety
	public class Link{
		 @JacksonXmlProperty(isAttribute = true)
		private String href;
		private String text;
		
		public Link() {
		}
		
		/**
		 * @return the href
		 */
		public String getHref() {
			return href;
		}
		/**
		 * @param href the href to set
		 */
		public void setHref(String href) {
			this.href = href;
		}
		/**
		 * @return the text
		 */
		public String getText() {
			return text;
		}
		/**
		 * @param text the text to set
		 */
		public void setText(String text) {
			this.text = text;
		}	
	}
	
	private String name;
	private String desc;
    private String author;
    private Link link;
    
    public Metadata() {
    	
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the link
	 */
	public Link getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(Link link) {
		this.link = link;
	}

}
