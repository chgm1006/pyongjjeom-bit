/**
 * 
 */

package com.pyongjjeom.user.dao; 

import com.pyongjjeom.notice.dto.Notice;
import com.pyongjjeom.user.dto.Member;


/**
 * <pre>
 * com.pyongjjeom.user.dao 
 *    |_ UserMapper.java
 * 
 * </pre>
 * @date : 2014. 6. 19. 오후 12:33:52
 * @version : 
 * @author : Forrest
 */
/**
 * <pre>
 * com.pyongjjeom.user.dao 
 *    |_ UserMapper.java
 * 
 * </pre>
 * @version : 
 * @author : Forrest
 */
public interface UserMapper {
	public Member getMemberInfo(String memCD);
	
	public Member checkMemberID(String memCD);
	
	void upDateData(Member member);
	

}
