package com.gceylan.service;

import java.util.HashMap;
import java.util.Map;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import com.gceylan.model.Process;
import com.gceylan.wmihelper.WMIConnection;


public class ProcessService {

	private String host;
	private ActiveXComponent axWMI;

	public ProcessService(String host) {
		this.host = host;
	}

	public Map<String, Process> getAllProcess() {
		String query = "SELECT * FROM Win32_Process";
		WMIConnection wmiConn = new WMIConnection(host);
		axWMI = wmiConn.setConnection();
		Variant vCollection = axWMI.invoke("ExecQuery", new Variant(query));

		Map<String, Process> allProcess = new HashMap<>();
		Process process = null;

		EnumVariant enumVariant = new EnumVariant(vCollection.toDispatch());
		Dispatch item = null;
		
		while (enumVariant.hasMoreElements()) { 
			item = enumVariant.nextElement().toDispatch();

			process = new Process();
			process.setProcessId(Dispatch.call(item, "ProcessId").toString());
			process.setCaption(Dispatch.call(item, "Caption").toString());
			process.setCommandLine(Dispatch.call(item, "CommandLine").toString());
			process.setCSName(Dispatch.call(item, "CSName").toString());
			process.setName(Dispatch.call(item, "Name").toString());
			process.setOSName(Dispatch.call(item, "OSName").toString());
			process.setParentProcessId(Dispatch.call(item, "ParentProcessId").toString());
			process.setExecutablePath(Dispatch.call(item, "ExecutablePath").toString());
			process.setWorkingSetSize(Dispatch.call(item, "WorkingSetSize").toString());
			
			allProcess.put(process.getProcessId(), process);
		}
		
		return allProcess;
	}
	
	public Process getProcessInf(String progName) {
		String query = "SELECT * FROM Win32_Process WHERE Caption='" + progName + "'";
		WMIConnection wmiConn = new WMIConnection(host);
		axWMI = wmiConn.setConnection();
		Variant vCollection = axWMI.invoke("ExecQuery", new Variant(query));
		
		Process process = null;

		EnumVariant enumVariant = new EnumVariant(vCollection.toDispatch());
		Dispatch item = null;
		
		if (enumVariant.hasMoreElements()) { 
			item = enumVariant.nextElement().toDispatch();

			process = new Process();
			process.setProcessId(Dispatch.call(item, "ProcessId").toString());
			process.setCaption(Dispatch.call(item, "Caption").toString());
			process.setCommandLine(Dispatch.call(item, "CommandLine").toString());
			process.setCSName(Dispatch.call(item, "CSName").toString());
			process.setName(Dispatch.call(item, "Name").toString());
			process.setOSName(Dispatch.call(item, "OSName").toString());
			process.setParentProcessId(Dispatch.call(item, "ParentProcessId").toString());
			process.setExecutablePath(Dispatch.call(item, "ExecutablePath").toString());
			process.setWorkingSetSize(Dispatch.call(item, "WorkingSetSize").toString());
		}
		
		return process;
	}
	
	public Map<String, Process> getAllProcessWithName(String processName) {
		String query = "SELECT * FROM Win32_Process WHERE Caption='" + processName + "'" ;
		WMIConnection wmiConn = new WMIConnection(host);
		axWMI = wmiConn.setConnection();
		Variant vCollection = axWMI.invoke("ExecQuery", new Variant(query));

		Map<String, Process> allProcess = new HashMap<>();
		Process process = null;

		EnumVariant enumVariant = new EnumVariant(vCollection.toDispatch());
		Dispatch item = null;
		
		while (enumVariant.hasMoreElements()) { 
			item = enumVariant.nextElement().toDispatch();

			process = new Process();
			process.setProcessId(Dispatch.call(item, "ProcessId").toString());
			process.setCaption(Dispatch.call(item, "Caption").toString());
			process.setCommandLine(Dispatch.call(item, "CommandLine").toString());
			process.setCSName(Dispatch.call(item, "CSName").toString());
			process.setName(Dispatch.call(item, "Name").toString());
			process.setOSName(Dispatch.call(item, "OSName").toString());
			process.setParentProcessId(Dispatch.call(item, "ParentProcessId").toString());
			process.setExecutablePath(Dispatch.call(item, "ExecutablePath").toString());
			process.setWorkingSetSize(Dispatch.call(item, "WorkingSetSize").toString());
			
			allProcess.put(process.getProcessId(), process);
		}
		
		return allProcess;
	}
}