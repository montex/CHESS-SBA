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
with Data_Structure; use Data_Structure;

package Remote_Msg_Server_Task is
   Pragma Elaborate_Body;

   -- Cannot use Time_Span for offset/period in task discriminant => Natural

   task type Thread_T
     (My_Task_ID : Task_Gen_ID;
      Thread_Priority : System.Any_Priority;
      Period : Natural;
      Init_Operation : access procedure;
      Operation : access procedure) is

      pragma Priority (Thread_Priority);
   end Thread_T;

end Remote_Msg_Server_Task;
