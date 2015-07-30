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

with Ada.Real_Time;
package System_Time is

   System_Start_Time  : constant
     Ada.Real_Time.Time := Ada.Real_Time.Clock;

   Task_Activation_Delay : constant
     Ada.Real_Time.Time_Span := Ada.Real_Time.Milliseconds (5_000);

end System_Time;
