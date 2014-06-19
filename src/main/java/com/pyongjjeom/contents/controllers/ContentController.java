/**
 * 
 */

package com.pyongjjeom.contents.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pyongjjeom.contents.dto.Content;
import com.pyongjjeom.contents.service.ContentService;

/**
 * <pre>
 * com.pyongjjeom.contents.controllers 
 *    |_ ContentController.java
 * 
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
@Controller
public class ContentController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getContents() {
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getContentDetail(String conCD) {
		return null;

	}
}
