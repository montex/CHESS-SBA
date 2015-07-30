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
with Ada.Text_IO; use Ada.Text_IO;

package body Cyclic_Task is

   use Ada.Real_Time;

   task body Thread_T is
      Task_Static_Offset : constant Time_Span := Milliseconds(Static_Offset);
      Task_Period : constant Time_Span := Milliseconds(Period);
      Next_Time : Time := System_Time.System_Start_Time +
        System_Time.Task_Activation_Delay + Task_Static_Offset;
      Assigned_Task_ID : constant Task_Gen_ID := My_Task_ID;
      Release_Time : Time;

   begin
      -- Suspend the task until first release;
      delay until Next_Time;


      Put("Task ");
      Put(Natural'Image(Natural(Assigned_Task_ID)));
      Put_Line(" first activation");

      Task_Loop :
      loop
         -- First action : enqueue for release
         Enqueue_for_Release.all (Release_Time);

         --  Execute the sequential operation
         Operation.all;

         -- Calculate new release time and suspend
         Next_Time:= Next_Time + Task_Period;
         delay until Next_Time;

      end loop Task_Loop;

   end Thread_T;

--   procedure Initialize is
--   begin
--      null;
--   end Initialize;

end Cyclic_Task;
