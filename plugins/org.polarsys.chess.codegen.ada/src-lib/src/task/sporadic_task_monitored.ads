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

with System;
with Data_Structure;
with Ada.Real_Time;
with Task_Monitors;

package Sporadic_Task_Monitored is

   -- Cannot use Time_Span for offset/period in task discriminant => Natural

   task type Thread_T
     (My_Task_ID : Data_Structure.Task_Gen_ID;
      Thread_Priority : System.Any_Priority;
      MIAT : Natural;
      Get_Request : access procedure (Req : out Data_Structure.Request_Descriptor_T;
      Release : out Ada.Real_Time.Time);
      Name : access String) is

      pragma Priority (Thread_Priority);
   end Thread_T;

end Sporadic_Task_Monitored;
