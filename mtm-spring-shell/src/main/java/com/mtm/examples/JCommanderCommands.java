//package com.mtm.examples;
//
//import javax.validation.Valid;
//
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellOption;
//
//@ShellComponent
//public class JCommanderCommands {
//
//	@ShellMethod("Bind parameters to JCommander POJO.")
//	public String jcommander(@ShellOption(optOut = true) @Valid Args args) {
//		return "You said " + args;
//	}
//}