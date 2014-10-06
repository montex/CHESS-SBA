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

package body System_Types is

   -- Bounded Queue ---------------------------------------------------

   procedure Initialize (Self : in out Bounded_Queue) is
   begin
      Self.Request_Pending  := 0;
      Self.Insert_Index  := Self.Param_Buffer'First;
      Self.Extract_Index := Self.Param_Buffer'First;
   end Initialize;

   procedure Put(Self : in out Bounded_Queue; P : in Param_Type_Ref) is
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

   procedure Get(Self : in out Bounded_Queue; R : out Request_Descriptor_T) is
   begin
      if Self.Request_Pending > 0 then
         R := (Params => Self.Param_Buffer(Self.Extract_Index));
         Self.Extract_Index := Self.Extract_Index + 1;
         if Self.Extract_Index > Self.Param_Buffer'Last then
            Self.Extract_Index := Self.Param_Buffer'First;
         end if;
         Self.Request_Pending := Self.Request_Pending - 1;
      end if;

      R.Params.In_Use := True;
   end Get;

   procedure Increase_Index(Self : in out Param_Buffer_T) is
   begin
      Self.Index := Self.Index + 1;
      if Self.Index > Self.Buffer'Last then
         Self.Index := Self.Buffer'First;
      end if;
   end Increase_Index;

end System_Types;
