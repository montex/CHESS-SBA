

// This C++ file was created by SanEditor

#include "Atomic/Test01/Test01SAN.h"

#include <stdlib.h>
#include <iostream.h>

#include <math.h>


/*****************************************************************
                         Test01SAN Constructor             
******************************************************************/


Test01SAN::Test01SAN(){


  Activity* InitialActionList[7]={
    &t_Instantaneous, //0
    &t_Exponential, //1
    &t_Deterministic, //2
    &t_Gaussian, //3
    &t_Uniform, //4
    &t_Gamma, //5
    &t_Weibull  // 6
  };

  BaseGroupClass* InitialGroupList[7]={
    (BaseGroupClass*) &(t_Exponential), 
    (BaseGroupClass*) &(t_Deterministic), 
    (BaseGroupClass*) &(t_Gaussian), 
    (BaseGroupClass*) &(t_Uniform), 
    (BaseGroupClass*) &(t_Gamma), 
    (BaseGroupClass*) &(t_Weibull), 
    (BaseGroupClass*) &(t_Instantaneous)
  };

  StartExponential = new Place("StartExponential" ,1);
  StartInstantaneous = new Place("StartInstantaneous" ,1);
  StartDeterministic = new Place("StartDeterministic" ,1);
  StartGaussian = new Place("StartGaussian" ,1);
  StartUniform = new Place("StartUniform" ,1);
  StartGamma = new Place("StartGamma" ,1);
  StartWeibull = new Place("StartWeibull" ,1);
  EndExponential = new Place("EndExponential" ,0);
  EndInstantaneous = new Place("EndInstantaneous" ,0);
  EndDeterministic = new Place("EndDeterministic" ,0);
  EndGaussian = new Place("EndGaussian" ,0);
  EndUniform = new Place("EndUniform" ,0);
  EndGamma = new Place("EndGamma" ,0);
  EndWeibull = new Place("EndWeibull" ,0);
  BaseStateVariableClass* InitialPlaces[14]={
    StartExponential,  // 0
    StartInstantaneous,  // 1
    StartDeterministic,  // 2
    StartGaussian,  // 3
    StartUniform,  // 4
    StartGamma,  // 5
    StartWeibull,  // 6
    EndExponential,  // 7
    EndInstantaneous,  // 8
    EndDeterministic,  // 9
    EndGaussian,  // 10
    EndUniform,  // 11
    EndGamma,  // 12
    EndWeibull   // 13
  };
  BaseStateVariableClass* InitialROPlaces[0]={
  };
  initializeSANModelNow("Test01", 14, InitialPlaces, 
                        0, InitialROPlaces, 
                        7, InitialActionList, 7, InitialGroupList);


  assignPlacesToActivitiesInst();
  assignPlacesToActivitiesTimed();

  int AffectArcs[14][2]={ 
    {1,0}, {8,0}, {0,1}, {7,1}, {2,2}, {9,2}, {3,3}, {10,3}, 
    {4,4}, {11,4}, {5,5}, {12,5}, {6,6}, {13,6}
  };
  for(int n=0;n<14;n++) {
    AddAffectArc(InitialPlaces[AffectArcs[n][0]],
                 InitialActionList[AffectArcs[n][1]]);
  }
  int EnableArcs[7][2]={ 
    {1,0}, {0,1}, {2,2}, {3,3}, {4,4}, {5,5}, {6,6}
  };
  for(int n=0;n<7;n++) {
    AddEnableArc(InitialPlaces[EnableArcs[n][0]],
                 InitialActionList[EnableArcs[n][1]]);
  }

  for(int n=0;n<7;n++) {
    InitialActionList[n]->LinkVariables();
  }
  CustomInitialization();

}

void Test01SAN::CustomInitialization() {

}
Test01SAN::~Test01SAN(){
  for (int i = 0; i < NumStateVariables-NumReadOnlyPlaces; i++)
    delete LocalStateVariables[i];
};

void Test01SAN::assignPlacesToActivitiesInst(){
  t_Instantaneous.StartInstantaneous = (Place*) LocalStateVariables[1];
  t_Instantaneous.EndInstantaneous = (Place*) LocalStateVariables[8];
}
void Test01SAN::assignPlacesToActivitiesTimed(){
  t_Exponential.StartExponential = (Place*) LocalStateVariables[0];
  t_Exponential.EndExponential = (Place*) LocalStateVariables[7];
  t_Deterministic.StartDeterministic = (Place*) LocalStateVariables[2];
  t_Deterministic.EndDeterministic = (Place*) LocalStateVariables[9];
  t_Gaussian.StartGaussian = (Place*) LocalStateVariables[3];
  t_Gaussian.EndGaussian = (Place*) LocalStateVariables[10];
  t_Uniform.StartUniform = (Place*) LocalStateVariables[4];
  t_Uniform.EndUniform = (Place*) LocalStateVariables[11];
  t_Gamma.StartGamma = (Place*) LocalStateVariables[5];
  t_Gamma.EndGamma = (Place*) LocalStateVariables[12];
  t_Weibull.StartWeibull = (Place*) LocalStateVariables[6];
  t_Weibull.EndWeibull = (Place*) LocalStateVariables[13];
}
/*****************************************************************/
/*                  Activity Method Definitions                  */
/*****************************************************************/

/*======================t_InstantaneousActivity========================*/


Test01SAN::t_InstantaneousActivity::t_InstantaneousActivity(){
  ActivityInitialize("t_Instantaneous",6,Instantaneous , RaceEnabled, 2,1, false);
}

void Test01SAN::t_InstantaneousActivity::LinkVariables(){
  StartInstantaneous->Register(&StartInstantaneous_Mobius_Mark);
  EndInstantaneous->Register(&EndInstantaneous_Mobius_Mark);
}

bool Test01SAN::t_InstantaneousActivity::Enabled(){
  OldEnabled=NewEnabled;
  NewEnabled=(((*(StartInstantaneous_Mobius_Mark)) >=1));
  return NewEnabled;
}

double Test01SAN::t_InstantaneousActivity::Weight(){ 
  return 1;
}

bool Test01SAN::t_InstantaneousActivity::ReactivationPredicate(){ 
  return false;
}

bool Test01SAN::t_InstantaneousActivity::ReactivationFunction(){ 
  return false;
}

double Test01SAN::t_InstantaneousActivity::SampleDistribution(){
  return 0;
}

double* Test01SAN::t_InstantaneousActivity::ReturnDistributionParameters(){
    return NULL;
}

int Test01SAN::t_InstantaneousActivity::Rank(){
  return 1;
}

BaseActionClass* Test01SAN::t_InstantaneousActivity::Fire(){
  (*(StartInstantaneous_Mobius_Mark))--;
  (*(EndInstantaneous_Mobius_Mark))++;
  return this;
}

/*======================t_ExponentialActivity========================*/

Test01SAN::t_ExponentialActivity::t_ExponentialActivity(){
  TheDistributionParameters = new double[1];
  ActivityInitialize("t_Exponential",0,Exponential, RaceEnabled, 2,1, false);
}

Test01SAN::t_ExponentialActivity::~t_ExponentialActivity(){
  delete[] TheDistributionParameters;
}

void Test01SAN::t_ExponentialActivity::LinkVariables(){
  StartExponential->Register(&StartExponential_Mobius_Mark);
  EndExponential->Register(&EndExponential_Mobius_Mark);
}

bool Test01SAN::t_ExponentialActivity::Enabled(){
  OldEnabled=NewEnabled;
  NewEnabled=(((*(StartExponential_Mobius_Mark)) >=1));
  return NewEnabled;
}

double Test01SAN::t_ExponentialActivity::Rate(){
  return Param1;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_ExponentialActivity::Weight(){ 
  return 1;
}

bool Test01SAN::t_ExponentialActivity::ReactivationPredicate(){ 
  return false;
}

bool Test01SAN::t_ExponentialActivity::ReactivationFunction(){ 
  return false;
}

double Test01SAN::t_ExponentialActivity::SampleDistribution(){
  return TheDistribution->Exponential(Param1);
}

double* Test01SAN::t_ExponentialActivity::ReturnDistributionParameters(){
  TheDistributionParameters[0] = Rate();
  return TheDistributionParameters;
}

int Test01SAN::t_ExponentialActivity::Rank(){
  return 1;
}

BaseActionClass* Test01SAN::t_ExponentialActivity::Fire(){
  (*(StartExponential_Mobius_Mark))--;
  (*(EndExponential_Mobius_Mark))++;
  return this;
}

/*======================t_DeterministicActivity========================*/

Test01SAN::t_DeterministicActivity::t_DeterministicActivity(){
  TheDistributionParameters = new double[1];
  ActivityInitialize("t_Deterministic",1,Deterministic, RaceEnabled, 2,1, false);
}

Test01SAN::t_DeterministicActivity::~t_DeterministicActivity(){
  delete[] TheDistributionParameters;
}

void Test01SAN::t_DeterministicActivity::LinkVariables(){
  StartDeterministic->Register(&StartDeterministic_Mobius_Mark);
  EndDeterministic->Register(&EndDeterministic_Mobius_Mark);
}

bool Test01SAN::t_DeterministicActivity::Enabled(){
  OldEnabled=NewEnabled;
  NewEnabled=(((*(StartDeterministic_Mobius_Mark)) >=1));
  return NewEnabled;
}

double Test01SAN::t_DeterministicActivity::DeterministicParamValue(){
  return Param1;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_DeterministicActivity::Weight(){ 
  return 1;
}

bool Test01SAN::t_DeterministicActivity::ReactivationPredicate(){ 
  return false;
}

bool Test01SAN::t_DeterministicActivity::ReactivationFunction(){ 
  return false;
}

double Test01SAN::t_DeterministicActivity::SampleDistribution(){
  return Param1;
}

double* Test01SAN::t_DeterministicActivity::ReturnDistributionParameters(){
  TheDistributionParameters[0] = DeterministicParamValue();
  return TheDistributionParameters;
}

int Test01SAN::t_DeterministicActivity::Rank(){
  return 1;
}

BaseActionClass* Test01SAN::t_DeterministicActivity::Fire(){
  (*(StartDeterministic_Mobius_Mark))--;
  (*(EndDeterministic_Mobius_Mark))++;
  return this;
}

/*======================t_GaussianActivity========================*/

Test01SAN::t_GaussianActivity::t_GaussianActivity(){
  TheDistributionParameters = new double[2];
  ActivityInitialize("t_Gaussian",2,Normal, RaceEnabled, 2,1, false);
}

Test01SAN::t_GaussianActivity::~t_GaussianActivity(){
  delete[] TheDistributionParameters;
}

void Test01SAN::t_GaussianActivity::LinkVariables(){
  StartGaussian->Register(&StartGaussian_Mobius_Mark);
  EndGaussian->Register(&EndGaussian_Mobius_Mark);
}

bool Test01SAN::t_GaussianActivity::Enabled(){
  OldEnabled=NewEnabled;
  NewEnabled=(((*(StartGaussian_Mobius_Mark)) >=1));
  return NewEnabled;
}

double Test01SAN::t_GaussianActivity::NormalParamMean(){
  return Param1;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_GaussianActivity::NormalParamVariance(){
  return Param2;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_GaussianActivity::Weight(){ 
  return 1;
}

bool Test01SAN::t_GaussianActivity::ReactivationPredicate(){ 
  return false;
}

bool Test01SAN::t_GaussianActivity::ReactivationFunction(){ 
  return false;
}

double Test01SAN::t_GaussianActivity::SampleDistribution(){
  return TheDistribution->Normal(Param1, Param2);
}

double* Test01SAN::t_GaussianActivity::ReturnDistributionParameters(){
  TheDistributionParameters[0] = NormalParamMean();
  TheDistributionParameters[1] = NormalParamVariance();
  return TheDistributionParameters;
}

int Test01SAN::t_GaussianActivity::Rank(){
  return 1;
}

BaseActionClass* Test01SAN::t_GaussianActivity::Fire(){
  (*(StartGaussian_Mobius_Mark))--;
  (*(EndGaussian_Mobius_Mark))++;
  return this;
}

/*======================t_UniformActivity========================*/

Test01SAN::t_UniformActivity::t_UniformActivity(){
  TheDistributionParameters = new double[2];
  ActivityInitialize("t_Uniform",3,Uniform, RaceEnabled, 2,1, false);
}

Test01SAN::t_UniformActivity::~t_UniformActivity(){
  delete[] TheDistributionParameters;
}

void Test01SAN::t_UniformActivity::LinkVariables(){
  StartUniform->Register(&StartUniform_Mobius_Mark);
  EndUniform->Register(&EndUniform_Mobius_Mark);
}

bool Test01SAN::t_UniformActivity::Enabled(){
  OldEnabled=NewEnabled;
  NewEnabled=(((*(StartUniform_Mobius_Mark)) >=1));
  return NewEnabled;
}

double Test01SAN::t_UniformActivity::UniformParamLowerBound(){
  return Param1;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_UniformActivity::UniformParamUpperBound(){
  return Param2;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_UniformActivity::Weight(){ 
  return 1;
}

bool Test01SAN::t_UniformActivity::ReactivationPredicate(){ 
  return false;
}

bool Test01SAN::t_UniformActivity::ReactivationFunction(){ 
  return false;
}

double Test01SAN::t_UniformActivity::SampleDistribution(){
  return TheDistribution->Uniform(Param1, Param2);
}

double* Test01SAN::t_UniformActivity::ReturnDistributionParameters(){
  TheDistributionParameters[0] = UniformParamLowerBound();
  TheDistributionParameters[1] = UniformParamUpperBound();
  return TheDistributionParameters;
}

int Test01SAN::t_UniformActivity::Rank(){
  return 1;
}

BaseActionClass* Test01SAN::t_UniformActivity::Fire(){
  (*(StartUniform_Mobius_Mark))--;
  (*(EndUniform_Mobius_Mark))++;
  return this;
}

/*======================t_GammaActivity========================*/

Test01SAN::t_GammaActivity::t_GammaActivity(){
  TheDistributionParameters = new double[2];
  ActivityInitialize("t_Gamma",4,Gamma, RaceEnabled, 2,1, false);
}

Test01SAN::t_GammaActivity::~t_GammaActivity(){
  delete[] TheDistributionParameters;
}

void Test01SAN::t_GammaActivity::LinkVariables(){
  StartGamma->Register(&StartGamma_Mobius_Mark);
  EndGamma->Register(&EndGamma_Mobius_Mark);
}

bool Test01SAN::t_GammaActivity::Enabled(){
  OldEnabled=NewEnabled;
  NewEnabled=(((*(StartGamma_Mobius_Mark)) >=1));
  return NewEnabled;
}

double Test01SAN::t_GammaActivity::GammaParamAlpha(){
  return Param1;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_GammaActivity::GammaParamBeta(){
  return Param2;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_GammaActivity::Weight(){ 
  return 1;
}

bool Test01SAN::t_GammaActivity::ReactivationPredicate(){ 
  return false;
}

bool Test01SAN::t_GammaActivity::ReactivationFunction(){ 
  return false;
}

double Test01SAN::t_GammaActivity::SampleDistribution(){
  return TheDistribution->Gamma(Param1, Param2);
}

double* Test01SAN::t_GammaActivity::ReturnDistributionParameters(){
  TheDistributionParameters[0] = GammaParamAlpha();
  TheDistributionParameters[1] = GammaParamBeta();
  return TheDistributionParameters;
}

int Test01SAN::t_GammaActivity::Rank(){
  return 1;
}

BaseActionClass* Test01SAN::t_GammaActivity::Fire(){
  (*(StartGamma_Mobius_Mark))--;
  (*(EndGamma_Mobius_Mark))++;
  return this;
}

/*======================t_WeibullActivity========================*/

Test01SAN::t_WeibullActivity::t_WeibullActivity(){
  TheDistributionParameters = new double[2];
  ActivityInitialize("t_Weibull",5,Weibull, RaceEnabled, 2,1, false);
}

Test01SAN::t_WeibullActivity::~t_WeibullActivity(){
  delete[] TheDistributionParameters;
}

void Test01SAN::t_WeibullActivity::LinkVariables(){
  StartWeibull->Register(&StartWeibull_Mobius_Mark);
  EndWeibull->Register(&EndWeibull_Mobius_Mark);
}

bool Test01SAN::t_WeibullActivity::Enabled(){
  OldEnabled=NewEnabled;
  NewEnabled=(((*(StartWeibull_Mobius_Mark)) >=1));
  return NewEnabled;
}

double Test01SAN::t_WeibullActivity::WeibullParamAlpha(){
  return Param1;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_WeibullActivity::WeibullParamBeta(){
  return Param2;
  return 1.0;  // default rate if none is specified
}

double Test01SAN::t_WeibullActivity::Weight(){ 
  return 1;
}

bool Test01SAN::t_WeibullActivity::ReactivationPredicate(){ 
  return false;
}

bool Test01SAN::t_WeibullActivity::ReactivationFunction(){ 
  return false;
}

double Test01SAN::t_WeibullActivity::SampleDistribution(){
  return TheDistribution->Weibull(Param1, Param2);
}

double* Test01SAN::t_WeibullActivity::ReturnDistributionParameters(){
  TheDistributionParameters[0] = WeibullParamAlpha();
  TheDistributionParameters[1] = WeibullParamBeta();
  return TheDistributionParameters;
}

int Test01SAN::t_WeibullActivity::Rank(){
  return 1;
}

BaseActionClass* Test01SAN::t_WeibullActivity::Fire(){
  (*(StartWeibull_Mobius_Mark))--;
  (*(EndWeibull_Mobius_Mark))++;
  return this;
}

