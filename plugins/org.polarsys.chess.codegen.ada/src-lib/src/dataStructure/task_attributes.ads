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
with System;

package Task_Attributes is

   -- Task_State

   type Task_Attributes_Record is abstract tagged record
      Relative_Deadline : Ada.Real_Time.Time_Span := Ada.Real_Time.Time_Span_Zero;
      Execution_Time : Ada.Real_Time.Time_Span := Ada.Real_Time.Time_Span_Zero;
      Prio : System.Any_Priority := System.Priority'First;
   end record;

   type Task_Attributes_ptr is access all Task_Attributes_Record'Class;

   -- Periodic_Task_State

   type Periodic_Task_Attributes_Record is new Task_Attributes_Record with record
      Period : Ada.Real_Time.Time_Span := Ada.Real_Time.Time_Span_Zero;
   end record;

   type Periodic_Task_Attributes_Record_ptr is access all
     Periodic_Task_Attributes_Record'Class;

   -- Sporadic_Task_State

   type Sporadic_Task_Attributes_Record is new Task_Attributes_Record with record
      MIAT : Ada.Real_Time.Time_Span := Ada.Real_Time.Time_Span_Zero;
   end record;

   type Sporadic_Task_Attributes_Record_ptr is access all
     Sporadic_Task_Attributes_Record'Class;

   -- Bursty_Task_State

   type Bursty_Task_Attributes_Record is new Task_Attributes_Record with record
      Burst_Interval : Ada.Real_Time.Time_Span := Ada.Real_Time.Time_Span_Zero;
      Max_Activations : Natural := 0;
   end record;

   type Bursty_Task_Attributes_Record_ptr is access all
     Bursty_Task_Attributes_Record'Class;

end Task_Attributes;
