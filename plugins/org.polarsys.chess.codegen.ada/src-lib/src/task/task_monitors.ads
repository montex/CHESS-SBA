with Ada.Real_Time;
with Runmon.Monitor;
with Runmon.Monitor.Logger;

package Task_Monitors is

   use Ada.Real_Time;

   package Mon is new
     Runmon.Monitor(Priority => 1, Period => Ada.Real_Time.Milliseconds(50));
   package Logger is new Mon.Logger;

end Task_Monitors;
