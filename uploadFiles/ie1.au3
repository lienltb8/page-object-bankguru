WinWait("Choose File to Upload","", "30")
if WinExists("Choose File to Upload") Then
   ControlSetText("Choose File to Upload","","Edit1",$CmdLine[1]);
   ControlClick("Choose File to Upload","", "Button1");
EndIf