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
with Ada.Real_Time;

package Container_Protection is


   -- ** Task_Release **
   -- Interface for the definition of descriptor-less release entries

   type Task_Release is protected interface;

   procedure Enqueue_For_Release(Self : in out Task_Release;
                                 Release_Time : out Ada.Real_Time.Time) is abstract;


   -- Interface for the definition of subprograms to control the release
   -- of tasks

   type Release_Control is limited interface;

   procedure Set_Release_Flag(Self : in out Release_Control;
                              New_Flag : in Boolean) is abstract;

   function Get_Release_Flag(Self : in Release_Control) return Boolean
                             is abstract;


   -- Simple OBCS used by cyclic tasks.
   -- Permits to block the execution of a task by setting
   -- the entry's barrier to false.
   protected type Release_Control_OBCS(C : System.Any_Priority) is new
        Task_Release and Release_Control with

      pragma Priority(C);

      overriding
      entry Enqueue_for_Release(Release_Time : out Ada.Real_Time.Time);

      overriding
      procedure Set_Release_Flag(New_Flag : in Boolean);

      overriding
      function Get_Release_Flag return Boolean;

   private
      Barrier : Boolean := True;
   end Release_Control_OBCS;


   protected type Simple_Counter_OBCS(C: System.Any_Priority; Size : Natural) is
      new Task_Release and Release_Control with

      pragma Priority(C);

      overriding
      entry Enqueue_for_Release(Release_Time : out Ada.Real_Time.Time);

      overriding
      procedure Set_Release_Flag(New_Flag : in Boolean);

      overriding
      function Get_Release_Flag return Boolean;


      procedure Put_Request;

   private
      Max_Pending : Natural := Size;
      Request_Pending : Natural := 0;
      Barrier : Boolean := True;
      Barrier_Release_Flag : Boolean := True;
   end Simple_Counter_OBCS;

end Container_Protection;
