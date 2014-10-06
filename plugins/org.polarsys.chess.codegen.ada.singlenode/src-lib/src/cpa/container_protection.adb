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


package body Container_Protection is

   --------------------------
   -- Release_Control_OBCS --
   --------------------------

   protected body Release_Control_OBCS is

      entry Enqueue_For_Release(Release_Time : out Ada.Real_Time.Time) when Barrier is
      begin
         Release_Time := Ada.Real_Time.Clock;
      end Enqueue_For_Release;

      procedure Set_Release_Flag(New_Flag : in Boolean) is
      begin
         Barrier := New_Flag;
      end Set_Release_Flag;

      function Get_Release_Flag return Boolean is
      begin
         return Barrier;
      end Get_Release_Flag;


   end Release_Control_OBCS;

   --------------------------
   -- Simple_Counter_OBCS --
   --------------------------

   protected body Simple_Counter_OBCS is

      procedure Update_Barrier is
      begin
         Barrier := Barrier_Release_Flag and Request_Pending > 0;
      end Update_Barrier;

      entry Enqueue_For_Release(Release_Time : out Ada.Real_Time.Time) when Barrier is
      begin
         Release_Time := Ada.Real_Time.Clock;
         Request_Pending := Request_Pending - 1;
         Update_Barrier;
      end Enqueue_For_Release;

      procedure Set_Release_Flag(New_Flag : in Boolean) is
      begin
         Barrier_Release_Flag := New_Flag;
         Update_Barrier;
      end Set_Release_Flag;

      function Get_Release_Flag return Boolean is
      begin
         return Barrier;
      end Get_Release_Flag;

      procedure Put_Request is
      begin
         if Request_Pending < Max_Pending then
            Request_Pending := Request_Pending + 1;
         end if;
         Update_Barrier;
      end Put_Request;

   end Simple_Counter_OBCS;



end Container_Protection;
