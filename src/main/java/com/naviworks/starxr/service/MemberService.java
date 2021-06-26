package com.naviworks.starxr.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.naviworks.starxr.repository.MemberRepository;
import com.naviworks.starxr.vo.KeywordVo;
import com.naviworks.starxr.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Value("${email.email}")
	private String user; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
	
	@Value("${email.password}")
    private String password;   // 패스워드
	
	private static final String hrefLogin = "http://localhost:8080/starxr-admin/login";
	public List<MemberVo> getMemberList() {
		return memberRepository.getMemberList();
	}

	public List<MemberVo> memberListByKeyword(KeywordVo keywordVo) {
		
		return memberRepository.getMemberListByKeyword(keywordVo);
	}

	public MemberVo memberByNo(Long no) {
		return memberRepository.getMemberByNo(no);
	}

	public MemberVo memberModify(Map<String, Object> map) {
		memberRepository.memberModify(map);
		return memberRepository.getModifyByNo((Long) map.get("no"));
	}

	public MemberVo memberDeleteByNo(KeywordVo keywordVo) {
		memberRepository.memberDeleteByNo(keywordVo.getNo());
		return memberByNo(memberRepository.memberDeleteNextByNo(keywordVo));
	}

	public MemberVo memberdeleteNextByNo(KeywordVo keywordVo) {
		return memberByNo(memberRepository.memberDeleteNextByNo(keywordVo));
	}

	public Long memberMaxCount(KeywordVo keywordVo) {
		return memberRepository.memberMaxCount(keywordVo);
	}

	public boolean rePassword(Long no, String email, String name) {
        // SMTP 서버 정보를 설정한다.
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", 465); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.ssl.enable", "true"); 
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        Random rnd =new Random();
        String buf ="";
        for(int i=0;i<6;i++){
            if(rnd.nextBoolean()){
                buf += (char)((int)(rnd.nextInt(26))+97);
            }else{
                buf += (rnd.nextInt(10));
            }
        }
        try {
        	   MimeMessage msg = new MimeMessage(session);
        	   msg.setSubject("[STARXR]비밀번호 변경안내입니다.");
        	   Address fromAddr = new InternetAddress(user); // 보내는 사람의 메일주소
        	   msg.setFrom(fromAddr);
        	   Address toAddr = new InternetAddress(email);  // 받는 사람의 메일주소
        	   msg.addRecipient(Message.RecipientType.TO, toAddr);
        	  
        	   MimeMultipart multipart = new MimeMultipart("related");
        	   
        	   // imagePath
        	   String url = this.getClass().getResource("").getPath(); 
        	   String imgPath = url.substring(1,url.indexOf(".metadata"))+"beans/starxr-admin/src/main/webapp/assets/admin/images/login/naviworks_logo.png";
        	   
        	   // first part  (the html)
        	   BodyPart messageBodyPart = new MimeBodyPart();
        	   String htmlText =  
        	   		"	<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\r\n" + 
        	   		"		<tr>\r\n" + 
        	   		"			<td>\r\n" + 
        	   		"				<img src=\"cid:naviworks_logo\" alt=\"logo\"></img>\r\n" + 
        	   		"			</td>\r\n" + 
        	   		"		</tr>\r\n" + 
        	   		"		<tr style=\\\"text-align: center;\\\">\r\n" + 
        	   		"			<td>\r\n" + 
        	   		"				<p><strong>"+name+"</strong>님, 반갑습니다.</p>\r\n" + 
        	   		"			</td>\r\n" + 
        	   		"		</tr>\r\n" + 
        	   		"		<tr style=\\\"text-align: center;\\\">\r\n" + 
        	   		"			<td>\r\n" + 
        	   		"				<p>비밀번호 변경이 완료되어 임시 비밀번호를 발급해드렸습니다.</p>\r\n" + 
        	   		"				<p><strong>"+buf+"</strong>  로 다시 로그인해주시기 바랍니다.</p>\r\n" + 
        	   		"			</td>\r\n" + 
        	   		"		</tr>\r\n" + 
        	   		"		<tr style=\\\"text-align: center;\\\">\r\n" + 
        	   		"			<td>\r\n" + 
        	   		"				<a href='" + hrefLogin + "'>로그인</a>\r\n" + 
        	   		"			</td>\r\n" + 
        	   		"		</tr>\r\n" + 
        	   		"	</table>\r\n";
        	   messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
        	 
        	   multipart.addBodyPart(messageBodyPart);
        	    
        	   messageBodyPart = new MimeBodyPart();
        	   DataSource fds = new FileDataSource(imgPath);
        	   messageBodyPart .setDataHandler(new DataHandler(fds));
        	   messageBodyPart .setHeader("Content-ID","<naviworks_logo>");
        	 
        	   // add it
        	   multipart.addBodyPart(messageBodyPart );
        	   
        	   msg.setContent(multipart);
        	 
        	   Transport.send(msg);

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePw = encoder.encode(buf);
        
		return memberRepository.reissuancePassword(no, encodePw);
	}
	
}
