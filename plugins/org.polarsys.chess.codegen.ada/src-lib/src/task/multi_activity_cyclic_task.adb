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

package body Multi_Activity_Cyclic_Task is

   task body Thread_T is
      Task_Static_Offset : constant Time_Span := Milliseconds(Static_Offset);
      Next_Time : Time := System_Time.System_Start_Time +
        System_Time.Task_Activation_Delay + Task_Static_Offset;
      Assigned_Task_ID : constant Data_Structure.Task_Gen_ID := My_Task_ID;
      Release_Time : Time;


   begin
      -- Suspend the task until first release;
      delay until Next_Time;

      --Put("Task ");
      --Put(Natural'Image(Natural(Assigned_Task_ID)));
      --Put_Line(" first activation");


      Task_Loop :
      loop
         -- First action : enqueue in the release entry of the CPA
         Enqueue_in_Entry.all (Release_Time);

         Activity_Loop:
         for I in Activity_Desc.all'Range loop

            if Activity_Desc.all(I).Is_Active then
               --Put(Natural'Image(Natural(Assigned_Task_ID)));
               Activity_Desc.all(I).activity.all;
            end if;

            if Activity_Desc.all(I).offset > Time_Span_Zero then
               --Put_Line("Preparing to issue suspension call");
               Next_Time:= Next_Time + Activity_Desc.all(I).offset;
               delay until Next_Time;
               --Put_Line("Woke up after suspension ");
            end if;

         end loop Activity_Loop;

      end loop Task_Loop;

   end Thread_T;

end Multi_Activity_Cyclic_Task;

