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

--with Ada.Text_IO; use Ada.Text_IO;

package body Data_Structure is

   ---Temp
   procedure My_OPCS (Self : in out Param_Type) is
   begin
      --Ada.Text_IO.Put_Line("Base My_OPCS ... You are not dispatching!");
      null;
   end My_OPCS;



   -------------------------
   -- Deactivate_Activity --
   -------------------------

   procedure Deactivate_Activity (TA_ref : Task_activity_desc_ref; Act_N : Integer)
   is
   begin
      --Put_Line("Deactivating activity");
      TA_ref.all(Act_N).is_Active := false;
      --Put("Activity ");
      --Put(Integer'Image(Act_N));
      --Put_Line(" deactivated");
   end Deactivate_Activity;

   ----------------------------------
   -- Deactivate_Activity (offset) --
   ----------------------------------

   procedure Deactivate_Activity (TA_ref : Task_activity_desc_ref; Act_N : Integer;
                                  New_offset : Ada.Real_Time.Time_Span)
   is
   begin
      --Put_Line("Deactivating activity");
      TA_ref.all(Act_N).is_Active := false;
      TA_ref.all(Act_N).offset := New_offset;
      --Put("Activity ");
      --Put(Integer'Image(Act_N));
      --Put_Line(" deactivated");
   end Deactivate_Activity;


   procedure Print_Activity_Desc (TA_ref : Task_activity_desc_ref)
   is
   begin
      for I in TA_ref.all'Range loop
         --Put("Activity ");
         --Put(Integer'Image(I));
         --Put_Line(Boolean'Image(TA_ref.all(I).is_Active));
         null;
      end loop;
   end Print_Activity_Desc;

   -------------------------
   -- Activate_Activity --
   -------------------------

   procedure Activate_Activity (TA_ref : Task_activity_desc_ref; Act_N : Integer)
   is
   begin
      TA_ref.all(Act_N).Is_Active := true;

   end Activate_Activity;


   --------------------------------
   -- Activate_Activity (offset) --
   --------------------------------

   procedure Activate_Activity (TA_ref : Task_activity_desc_ref; Act_N : Integer;
                                new_offset : Ada.Real_Time.Time_Span)
   is
   begin
      TA_ref.all(Act_N).Is_Active := true;
      TA_ref.all(Act_N).offset := new_offset;

   end Activate_Activity;




   --- Param_Buffer_T.Increase_Index

   procedure Increase_Index(Self : in out Param_Buffer_T) is
   begin
      Self.Index := Self.Index + 1;
      if Self.Index > Self.Buffer'Last then
         Self.Index := Self.Buffer'First;
      end if;
   end Increase_Index;


   --- Subprograms for Request_Queue

   procedure Initialize (Self : in out Request_Queue) is
   begin
      Self.Request_Pending       := 0;
      Self.Insert_Index  := Self.Param_Buffer'First;
      Self.Extract_Index := Self.Param_Buffer'First;
   end Initialize;

   procedure Put(Self : in out Request_Queue; P : Param_Type_Ref) is
   begin
      Self.Param_Buffer (Self.Insert_Index) := P;
      Self.Insert_Index := Self.Insert_Index + 1;
      if Self.Insert_Index > Self.Param_Buffer'Last then
         Self.Insert_Index := Self.Param_Buffer'First;
      end if;
      --increase the number of pending requests but do not
      --overcome the number of buffered ones
      if Self.Request_Pending < Self.Param_Buffer'Last then
         Self.Request_Pending := Self.Request_Pending + 1;
      end if;

   end Put;

   procedure Get(Self : in out Request_Queue;
                 R : out Request_Descriptor_T) is
   begin
      if Self.Request_Pending > 0 then
         R := (Params => Self.Param_Buffer(Self.Extract_Index));
         Self.Extract_Index := Self.Extract_Index + 1;
         if Self.Extract_Index > Self.Param_Buffer'Last then
            Self.Extract_Index := Self.Param_Buffer'First;
         end if;
         Self.Request_Pending := Self.Request_Pending - 1;
      end if;

      R.Params.all.In_Use := True;

   end Get;

   -- Generate_Task_ID

   function Generate_Task_ID return Task_Gen_ID is
   begin
      Next_Task_ID_to_assign := Next_Task_ID_to_assign + 1;
      return Next_Task_ID_to_assign;
   end Generate_Task_ID;

end Data_Structure;
