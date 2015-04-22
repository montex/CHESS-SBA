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
with Ada.Real_Time;
with Ada.Text_IO; use Ada.Text_IO;
with Middleware_Realtime_Attribute;

package body Remote_Msg_Server_Task is

   use Ada.Real_Time;

   task body Thread_T is
      Task_Period : constant Time_Span := Milliseconds(Period);
      Next_Time : Time := System_Time.System_Start_Time +
        System_Time.Task_Activation_Delay;
      Assigned_Task_ID : constant Task_Gen_ID := My_Task_ID;

   begin
      -- Initialize the Remote Msg Server

      delay until System_Time.System_Start_Time +
        Ada.Real_Time.Milliseconds(Middleware_Realtime_Attribute.Remote_Msg_Server_Init_Delay);

      Ada.Text_IO.Put_Line("Initializing Remote Msg Server...");
      Init_Operation.all;
      -- Suspend the task until first release;
      Ada.Text_IO.Put_Line("Initialization of Remote Msg Server complete.");
      Ada.Text_IO.Put_Line(" ************************* ");
      Ada.Text_IO.New_Line;
      Ada.Text_IO.New_Line;
      delay until Next_Time;

      Put("Remote Msg Server Task ");
      Put(Natural'Image(Natural(Assigned_Task_ID)));
      Put_Line(" first activation");

      Task_Loop :
      loop
         --  Execute the sequential operation
         Operation.all;
         -- Calculate new release time and suspend
         Next_Time:= Next_Time + Task_Period;
         delay until Next_Time;

      end loop Task_Loop;

   end Thread_T;

end Remote_Msg_Server_Task;
