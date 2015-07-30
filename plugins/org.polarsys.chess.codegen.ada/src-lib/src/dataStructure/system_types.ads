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


--with System; use System;
--with Ada.Real_Time; use Ada.Real_Time;
with Ada.Finalization; use Ada.Finalization;

package System_Types is

   -- Abstract Parameter type --------------------------------------------------
   type Param_Type is abstract tagged record
      In_Use : Boolean := False;
   end record;

   -- Abstract sequential procedure
   procedure My_OPCS (Self : in out Param_Type) is abstract;

   type Param_Type_Ref is access all Param_Type'Class;

   type Param_Arr is array(Integer range <>) of Param_Type_Ref;

   type Param_Arr_Ref is access all Param_Arr;

   --+--------------------------------------------------------------------------

   -- Request Descriptor -------------------------------------------------------

   type Request_Descriptor_T is
      record
         --Request : Request_T;
         Params : Param_Type_Ref;
      end record;

   --+--------------------------------------------------------------------------

   -- Abstract Queue

   type Queue_T is abstract new Controlled with null record;
   --type Queue_T is abstract tagged null record;
   type Queue_T_Ref is access all Queue_T'Class;

   procedure Put(Self : in out Queue_T; P : Param_Type_Ref)
   is abstract;
   procedure Get(Self : in out Queue_T; R : out Request_Descriptor_T)
   is abstract;

   -- Bounded Queue ---------------------------------------------------------
   type Bounded_Queue(Size : Natural) is new Queue_T with
      record
         Param_Buffer : Param_Arr(1..Size);
         Insert_Index : Natural;
         Extract_Index : Natural;
         Request_Pending : Natural;
      end record;

   overriding
   procedure Put(Self : in out Bounded_Queue; P : in Param_Type_Ref);

   overriding
   procedure Get(Self : in out Bounded_Queue; R : out Request_Descriptor_T);

   overriding
   procedure Initialize(Self : in out Bounded_Queue);
   --+--------------------------------------------------------------------------

   -- Param_Buffer: buffer + index --------------------------
   type Param_Buffer_T(Size : Integer) is
      record
         Buffer : aliased Param_Arr(1..Size);
         Index : Integer := 1;
      end record;

   type Param_Buffer_Ref is access all Param_Buffer_T;

   procedure Increase_Index(Self : in out Param_Buffer_T);

end System_Types;
