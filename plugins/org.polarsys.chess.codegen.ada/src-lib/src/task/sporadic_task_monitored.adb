-----------------------------------------------------------------------
--           Code Archetypes for the CHESS Component Model           --
--                                                                   --
--                   Copyright (C) 2011-2012                         --
--                 University of Padova, ITALY                       --
--                                                                   --
-- Author: Marco Panunzio         panunzio@math.unipd.it             --
--                                                                   --
-- All rights reserved. This program and the accompanying materials  --
-- are made available under the terms of the Eclipse Public License  --
-- v1.0 which accompanies this distribution, and is available at     --
-- http://www.eclipse.org/legal/epl-v10.html                         --
-----------------------------------------------------------------------

with System_Time;
with Ada.Real_Time; use Ada.Real_Time;
with Ada.Text_IO;

package body Sporadic_Task_Monitored is

   --------------
   -- Thread_T --
   --------------

   task body Thread_T is
      Req_Desc : Data_Structure.Request_Descriptor_T;
      Release : Time;
      Task_MIAT : constant Time_Span := Milliseconds(MIAT);
      Next_Time : Time := System_Time.System_Start_Time +
        System_Time.Task_Activation_Delay;
      Assigned_Task_ID : constant Data_Structure.Task_Gen_ID := My_Task_ID;
   begin
 	  Task_Monitors.Logger.Register(Thread_ID=> System.OS_Interface.Thread_Self, Name=>Name);
      
      -- Suspend the task until first release;
      delay until Next_Time;

      Ada.Text_IO.Put("Task ");
      Ada.Text_IO.Put(Natural'Image(Natural(Assigned_Task_ID)));
      Ada.Text_IO.Put_Line(" first activation");
      Task_Loop :
      loop
         -- First action : enqueue in the release entry of the CPA
         Get_Request(Req_Desc, Release);

         --  Execute the sequential operation
         --Ada.Text_IO.Put_Line("Sporadic Task: Calling My_OPCS");
         Data_Structure.My_OPCS(Req_Desc.Params.all);

         -- Calculate the new earliest release time and suspend
         Next_Time := Release + Task_MIAT;
         delay until Next_Time;
      end loop Task_Loop;

   end Thread_T;

end Sporadic_Task_Monitored;
