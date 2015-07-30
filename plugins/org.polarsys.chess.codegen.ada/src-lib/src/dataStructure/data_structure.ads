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
with Ada.Finalization;

package Data_Structure is

   -- Not declared in the private part because otherwise it is not a discrete type,
   -- hence cannot be passed as discriminant of a Task
   type Task_Gen_ID is new Natural;

   type Task_activity_desc_elem is
      record
         activity: access procedure;
         offset: Ada.Real_Time.Time_Span;
         is_Active : Boolean;
   end record;

   type Task_activity_desc is array(Natural range <>) of Task_activity_desc_elem;

   type Task_activity_desc_ref is access all Task_activity_desc;


   procedure Deactivate_Activity(TA_ref : Task_activity_desc_ref; Act_N : Integer);

   procedure Activate_Activity(TA_ref : Task_activity_desc_ref; Act_N : Integer);

   procedure Print_Activity_Desc(TA_ref : Task_activity_desc_ref);

   procedure Activate_Activity(TA_ref : Task_activity_desc_ref; Act_N : Integer;
                               New_offset : Ada.Real_Time.Time_Span);

   procedure Deactivate_Activity(TA_ref : Task_activity_desc_ref; Act_N: Integer;
                                 New_offset : Ada.Real_Time.Time_Span);

   function Generate_Task_ID return Task_Gen_ID;


   --- Parameter

   type Param_Type is abstract tagged record
      In_Use : Boolean := False;
   end record;

   -- Abstract sequential procedure
   procedure My_OPCS (Self : in out Param_Type);

   type Param_Type_Ref is access all Param_Type'Class;

   type Param_Arr is array(Integer range <>) of Param_Type_Ref;

   type Param_Arr_Ref is access all Param_Arr;

   -- Request descriptor
   type Request_Descriptor_T is
      record
         --Request : Request_T;
         Params : Param_Type_Ref;
      end record;

   --- Param_Buffer: buffer + index --------------------------
   type Param_Buffer_T(Size : Natural) is
      record
         Buffer : aliased Param_Arr(1..Size);
         Index : Integer := 1;
      end record;

   type Param_Buffer_Ref is access all Param_Buffer_T;

   procedure Increase_Index(Self : in out Param_Buffer_T);

   type Request_Queue(Size : Positive) is new Ada.Finalization.Controlled with
      record
         Param_Buffer : Param_Arr(1..Size);
         Insert_Index : Integer;
         Extract_Index : Integer;
         Request_Pending : Natural := 0;
      end record;

   procedure Initialize(Self : in out Request_Queue);

   procedure Put(Self : in out Request_Queue;
                 P : Param_Type_Ref);

   procedure Get(Self : in out Request_Queue;
                 R : out Request_Descriptor_T);

private
   Next_Task_ID_to_assign : Task_Gen_ID := 0;

end Data_Structure;
