#include "RewTest01PVNodes.h"

RewTest01PV0Worker::RewTest01PV0Worker()
{
  NumModels = 1;
  TheModelPtr = new BaseModelClass**[NumModels];
  TheModelPtr[0] = (BaseModelClass**)(&Test01);
}

RewTest01PV0Worker::~RewTest01PV0Worker() {
  delete [] TheModelPtr;
}

double RewTest01PV0Worker::Reward_Function(void) {

return Test01->EndInstantaneous->Mark() > 0;

return (0);



}

RewTest01PV0::RewTest01PV0(int timeindex) {
  TheModelPtr = (BaseModelClass**)(&TheTest01SAN);
  double startpts[1]={TestTime};
  double stoppts[1]={TestTime};
  Initialize("p_Instantaneous",(RewardType)0,1, startpts, stoppts, timeindex, 0,1, 1);
  AddVariableDependency("EndInstantaneous","Test01");
}

RewTest01PV0::~RewTest01PV0() {
  for(int i = 0; i < NumberOfWorkers; i++) {
    delete[] WorkerList[i]->Name;
    delete WorkerList[i];
  }
}

void RewTest01PV0::CreateWorkerList(void) {
  for(int i = 0; i < NumberOfWorkers; i++)
    WorkerList[i] = new RewTest01PV0Worker;
}
RewTest01PV1Worker::RewTest01PV1Worker()
{
  NumModels = 1;
  TheModelPtr = new BaseModelClass**[NumModels];
  TheModelPtr[0] = (BaseModelClass**)(&Test01);
}

RewTest01PV1Worker::~RewTest01PV1Worker() {
  delete [] TheModelPtr;
}

double RewTest01PV1Worker::Reward_Function(void) {

return Test01->EndExponential->Mark() > 0;

return (0);



}

RewTest01PV1::RewTest01PV1(int timeindex) {
  TheModelPtr = (BaseModelClass**)(&TheTest01SAN);
  double startpts[1]={TestTime};
  double stoppts[1]={TestTime};
  Initialize("p_Exponential",(RewardType)0,1, startpts, stoppts, timeindex, 0,1, 1);
  AddVariableDependency("EndExponential","Test01");
}

RewTest01PV1::~RewTest01PV1() {
  for(int i = 0; i < NumberOfWorkers; i++) {
    delete[] WorkerList[i]->Name;
    delete WorkerList[i];
  }
}

void RewTest01PV1::CreateWorkerList(void) {
  for(int i = 0; i < NumberOfWorkers; i++)
    WorkerList[i] = new RewTest01PV1Worker;
}
RewTest01PV2Worker::RewTest01PV2Worker()
{
  NumModels = 1;
  TheModelPtr = new BaseModelClass**[NumModels];
  TheModelPtr[0] = (BaseModelClass**)(&Test01);
}

RewTest01PV2Worker::~RewTest01PV2Worker() {
  delete [] TheModelPtr;
}

double RewTest01PV2Worker::Reward_Function(void) {

return Test01->EndDeterministic->Mark() > 0;

return (0);



}

RewTest01PV2::RewTest01PV2(int timeindex) {
  TheModelPtr = (BaseModelClass**)(&TheTest01SAN);
  double startpts[1]={TestTime};
  double stoppts[1]={TestTime};
  Initialize("p_Deterministic",(RewardType)0,1, startpts, stoppts, timeindex, 0,1, 1);
  AddVariableDependency("EndDeterministic","Test01");
}

RewTest01PV2::~RewTest01PV2() {
  for(int i = 0; i < NumberOfWorkers; i++) {
    delete[] WorkerList[i]->Name;
    delete WorkerList[i];
  }
}

void RewTest01PV2::CreateWorkerList(void) {
  for(int i = 0; i < NumberOfWorkers; i++)
    WorkerList[i] = new RewTest01PV2Worker;
}
RewTest01PV3Worker::RewTest01PV3Worker()
{
  NumModels = 1;
  TheModelPtr = new BaseModelClass**[NumModels];
  TheModelPtr[0] = (BaseModelClass**)(&Test01);
}

RewTest01PV3Worker::~RewTest01PV3Worker() {
  delete [] TheModelPtr;
}

double RewTest01PV3Worker::Reward_Function(void) {

return Test01->EndGaussian->Mark() > 0;

return (0);



}

RewTest01PV3::RewTest01PV3(int timeindex) {
  TheModelPtr = (BaseModelClass**)(&TheTest01SAN);
  double startpts[1]={TestTime};
  double stoppts[1]={TestTime};
  Initialize("p_Gaussian",(RewardType)0,1, startpts, stoppts, timeindex, 0,1, 1);
  AddVariableDependency("EndGaussian","Test01");
}

RewTest01PV3::~RewTest01PV3() {
  for(int i = 0; i < NumberOfWorkers; i++) {
    delete[] WorkerList[i]->Name;
    delete WorkerList[i];
  }
}

void RewTest01PV3::CreateWorkerList(void) {
  for(int i = 0; i < NumberOfWorkers; i++)
    WorkerList[i] = new RewTest01PV3Worker;
}
RewTest01PV4Worker::RewTest01PV4Worker()
{
  NumModels = 1;
  TheModelPtr = new BaseModelClass**[NumModels];
  TheModelPtr[0] = (BaseModelClass**)(&Test01);
}

RewTest01PV4Worker::~RewTest01PV4Worker() {
  delete [] TheModelPtr;
}

double RewTest01PV4Worker::Reward_Function(void) {

return Test01->EndUniform->Mark() > 0;

return (0);



}

RewTest01PV4::RewTest01PV4(int timeindex) {
  TheModelPtr = (BaseModelClass**)(&TheTest01SAN);
  double startpts[1]={TestTime};
  double stoppts[1]={TestTime};
  Initialize("p_Uniform",(RewardType)0,1, startpts, stoppts, timeindex, 0,1, 1);
  AddVariableDependency("EndUniform","Test01");
}

RewTest01PV4::~RewTest01PV4() {
  for(int i = 0; i < NumberOfWorkers; i++) {
    delete[] WorkerList[i]->Name;
    delete WorkerList[i];
  }
}

void RewTest01PV4::CreateWorkerList(void) {
  for(int i = 0; i < NumberOfWorkers; i++)
    WorkerList[i] = new RewTest01PV4Worker;
}
RewTest01PV5Worker::RewTest01PV5Worker()
{
  NumModels = 1;
  TheModelPtr = new BaseModelClass**[NumModels];
  TheModelPtr[0] = (BaseModelClass**)(&Test01);
}

RewTest01PV5Worker::~RewTest01PV5Worker() {
  delete [] TheModelPtr;
}

double RewTest01PV5Worker::Reward_Function(void) {

return Test01->EndGamma->Mark() > 0;

return (0);



}

RewTest01PV5::RewTest01PV5(int timeindex) {
  TheModelPtr = (BaseModelClass**)(&TheTest01SAN);
  double startpts[1]={TestTime};
  double stoppts[1]={TestTime};
  Initialize("p_Gamma",(RewardType)0,1, startpts, stoppts, timeindex, 0,1, 1);
  AddVariableDependency("EndGamma","Test01");
}

RewTest01PV5::~RewTest01PV5() {
  for(int i = 0; i < NumberOfWorkers; i++) {
    delete[] WorkerList[i]->Name;
    delete WorkerList[i];
  }
}

void RewTest01PV5::CreateWorkerList(void) {
  for(int i = 0; i < NumberOfWorkers; i++)
    WorkerList[i] = new RewTest01PV5Worker;
}
RewTest01PV6Worker::RewTest01PV6Worker()
{
  NumModels = 1;
  TheModelPtr = new BaseModelClass**[NumModels];
  TheModelPtr[0] = (BaseModelClass**)(&Test01);
}

RewTest01PV6Worker::~RewTest01PV6Worker() {
  delete [] TheModelPtr;
}

double RewTest01PV6Worker::Reward_Function(void) {

return Test01->EndWeibull->Mark() > 0;

return (0);



}

RewTest01PV6::RewTest01PV6(int timeindex) {
  TheModelPtr = (BaseModelClass**)(&TheTest01SAN);
  double startpts[1]={TestTime};
  double stoppts[1]={TestTime};
  Initialize("p_Weibull",(RewardType)0,1, startpts, stoppts, timeindex, 0,1, 1);
  AddVariableDependency("EndWeibull","Test01");
}

RewTest01PV6::~RewTest01PV6() {
  for(int i = 0; i < NumberOfWorkers; i++) {
    delete[] WorkerList[i]->Name;
    delete WorkerList[i];
  }
}

void RewTest01PV6::CreateWorkerList(void) {
  for(int i = 0; i < NumberOfWorkers; i++)
    WorkerList[i] = new RewTest01PV6Worker;
}
