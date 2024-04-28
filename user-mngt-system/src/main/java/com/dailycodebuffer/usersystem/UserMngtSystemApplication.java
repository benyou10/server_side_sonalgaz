package com.dailycodebuffer.usersystem;

import com.zkteco.Enum.UserRoleEnum;
import com.zkteco.commands.UserInfo;
import com.zkteco.commands.ZKCommandReply;
import com.zkteco.terminal.ZKTerminal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UserMngtSystemApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserMngtSystemApplication.class, args);
//		try {
//			System.out.println("------------------------");
//			ZKTerminal terminal = new ZKTerminal("10.1.164.13", 4370);
//			ZKCommandReply reply = terminal.connect();
//			reply = terminal.connectAuth(1958);
//			System.out.println(terminal.getCommKey());
//			List<UserInfo> userList = terminal.getAllUsers();
//			int cpt=0;
//			// Access and print user information
//			for (UserInfo user : userList) {
//				if((user.getRole()) != UserRoleEnum.USER_DEFAULT) {
//					System.out.println(cpt++);
//					System.out.println("User ID: " + user.getUserid());
//					System.out.println("Name: " + user.getName());
//					System.out.println("Password: " + user.getPassword());
//					System.out.println("Card Number: " + user.getCardno());
//					System.out.println("Group Number: " + user.getGroupNumber());
//					System.out.println("User TimeZone Flag: " + user.getUserTimeZoneFlag());
//					System.out.println("TimeZone1: " + user.getTimeZone1());
//					System.out.println("TimeZone2: " + user.getTimeZone2());
//					System.out.println("TimeZone3: " + user.getTimeZone3());
//					System.out.println("User Serial Number: " + user.getUid());
//					System.out.println("Role: " + user.getRole());
//
//					System.out.println("------------------------");
//				}
//			}
//		}catch (Exception e){
//			System.out.println("connetion failed");
//		}
//
//
//		System.out.println("------------------------");
//		ZKTerminal terminal = new ZKTerminal("10.1.164.13", 4370);
//		ZKCommandReply reply = terminal.connect();
//		reply = terminal.connectAuth(1958);
//		System.out.println(terminal.getCommKey());
//		List<UserInfo> userList = terminal.getAllUsers();
//		int cpt=0;
//		// Access and print user information
//		for (UserInfo user : userList) {
//			if ((user.getRole()) != UserRoleEnum.USER_DEFAULT) {
//				System.out.println(cpt++);
//				System.out.println("User ID: " + user.getUserid());
//				System.out.println("Name: " + user.getName());
//				System.out.println("Password: " + user.getPassword());
//				System.out.println("Card Number: " + user.getCardno());
//				System.out.println("Group Number: " + user.getGroupNumber());
//				System.out.println("User TimeZone Flag: " + user.getUserTimeZoneFlag());
//				System.out.println("TimeZone1: " + user.getTimeZone1());
//				System.out.println("TimeZone2: " + user.getTimeZone2());
//				System.out.println("TimeZone3: " + user.getTimeZone3());
//				System.out.println("User Serial Number: " + user.getUid());
//				System.out.println("Role: " + user.getRole());
//
//				System.out.println("------------------------");
//			}
//		}
}

}
