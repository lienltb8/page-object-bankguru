WinWait("File Upload","", "20")
If WinExists("File Upload") Then
	ControlSetText("File Upload", "", "Edit1", $CmdLine[1]);
	ControlClick("File Upload", "","&Edit1");
EndIf