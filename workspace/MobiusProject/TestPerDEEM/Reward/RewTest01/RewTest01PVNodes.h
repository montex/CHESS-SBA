#ifndef _REWTEST01_PVS_
#define _REWTEST01_PVS_
#include <math.h>
#include "Cpp/Performance_Variables/PerformanceVariableNode.hpp"
#include "Atomic/Test01/Test01SAN.h"
#include "Cpp/Performance_Variables/InstantOfTime.hpp"

extern double TestTime;

class RewTest01PV0Worker:public InstantOfTime
{
 public:
  Test01SAN *Test01;
  
  RewTest01PV0Worker();
  ~RewTest01PV0Worker();
  double Reward_Function();
};

class RewTest01PV0:public PerformanceVariableNode
{
 public:
  Test01SAN *TheTest01SAN;

  RewTest01PV0Worker *RewTest01PV0WorkerList;

  RewTest01PV0(int timeindex=0);
  ~RewTest01PV0();
  void CreateWorkerList(void);
};

class RewTest01PV1Worker:public InstantOfTime
{
 public:
  Test01SAN *Test01;
  
  RewTest01PV1Worker();
  ~RewTest01PV1Worker();
  double Reward_Function();
};

class RewTest01PV1:public PerformanceVariableNode
{
 public:
  Test01SAN *TheTest01SAN;

  RewTest01PV1Worker *RewTest01PV1WorkerList;

  RewTest01PV1(int timeindex=0);
  ~RewTest01PV1();
  void CreateWorkerList(void);
};

class RewTest01PV2Worker:public InstantOfTime
{
 public:
  Test01SAN *Test01;
  
  RewTest01PV2Worker();
  ~RewTest01PV2Worker();
  double Reward_Function();
};

class RewTest01PV2:public PerformanceVariableNode
{
 public:
  Test01SAN *TheTest01SAN;

  RewTest01PV2Worker *RewTest01PV2WorkerList;

  RewTest01PV2(int timeindex=0);
  ~RewTest01PV2();
  void CreateWorkerList(void);
};

class RewTest01PV3Worker:public InstantOfTime
{
 public:
  Test01SAN *Test01;
  
  RewTest01PV3Worker();
  ~RewTest01PV3Worker();
  double Reward_Function();
};

class RewTest01PV3:public PerformanceVariableNode
{
 public:
  Test01SAN *TheTest01SAN;

  RewTest01PV3Worker *RewTest01PV3WorkerList;

  RewTest01PV3(int timeindex=0);
  ~RewTest01PV3();
  void CreateWorkerList(void);
};

class RewTest01PV4Worker:public InstantOfTime
{
 public:
  Test01SAN *Test01;
  
  RewTest01PV4Worker();
  ~RewTest01PV4Worker();
  double Reward_Function();
};

class RewTest01PV4:public PerformanceVariableNode
{
 public:
  Test01SAN *TheTest01SAN;

  RewTest01PV4Worker *RewTest01PV4WorkerList;

  RewTest01PV4(int timeindex=0);
  ~RewTest01PV4();
  void CreateWorkerList(void);
};

class RewTest01PV5Worker:public InstantOfTime
{
 public:
  Test01SAN *Test01;
  
  RewTest01PV5Worker();
  ~RewTest01PV5Worker();
  double Reward_Function();
};

class RewTest01PV5:public PerformanceVariableNode
{
 public:
  Test01SAN *TheTest01SAN;

  RewTest01PV5Worker *RewTest01PV5WorkerList;

  RewTest01PV5(int timeindex=0);
  ~RewTest01PV5();
  void CreateWorkerList(void);
};

class RewTest01PV6Worker:public InstantOfTime
{
 public:
  Test01SAN *Test01;
  
  RewTest01PV6Worker();
  ~RewTest01PV6Worker();
  double Reward_Function();
};

class RewTest01PV6:public PerformanceVariableNode
{
 public:
  Test01SAN *TheTest01SAN;

  RewTest01PV6Worker *RewTest01PV6WorkerList;

  RewTest01PV6(int timeindex=0);
  ~RewTest01PV6();
  void CreateWorkerList(void);
};

#endif
