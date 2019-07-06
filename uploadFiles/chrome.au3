WinWait("Open","", "20")
If WinExists("Open") Then
	ControlSetText("Open", "", "Edit1", $CmdLine[1]);
	ControlClick("Open", "","Button1");
EndIf