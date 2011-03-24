#ifndef Test01SAN_H_
#define Test01SAN_H_

#include "Cpp/BaseClasses/EmptyGroup.h"
#include "Cpp/BaseClasses/PreselectGroup.h"
#include "Cpp/BaseClasses/PostselectGroup.h"
#include "Cpp/BaseClasses/state/StructStateVariable.h"
#include "Cpp/BaseClasses/state/ArrayStateVariable.h"
#include "Cpp/BaseClasses/SAN/SANModel.h" 
#include "Cpp/BaseClasses/SAN/Place.h"
#include "Cpp/BaseClasses/SAN/ExtendedPlace.h"
extern double Param1;
extern double Param2;
extern UserDistributions* TheDistribution;

void MemoryError();


/*********************************************************************
               Test01SAN Submodel Definition                   
*********************************************************************/

class Test01SAN:public SANModel{
public:

class t_InstantaneousActivity:public Activity {
public:

  Place* StartInstantaneous;
  short* StartInstantaneous_Mobius_Mark;
  Place* EndInstantaneous;
  short* EndInstantaneous_Mobius_Mark;

  double* TheDistributionParameters;
  t_InstantaneousActivity();
  double Rate(){return 0;}
  bool Enabled();
  void LinkVariables();
  double Weight();
  bool ReactivationPredicate();
  bool ReactivationFunction();
  double SampleDistribution();
  double* ReturnDistributionParameters();
  int Rank();
  BaseActionClass* Fire();
}; // t_InstantaneousActivityActivity

class t_ExponentialActivity:public Activity {
public:

  Place* StartExponential;
  short* StartExponential_Mobius_Mark;
  Place* EndExponential;
  short* EndExponential_Mobius_Mark;

  double* TheDistributionParameters;
  t_ExponentialActivity();
  ~t_ExponentialActivity();
  bool Enabled();
  void LinkVariables();
  double Weight();
  bool ReactivationPredicate();
  bool ReactivationFunction();
  double SampleDistribution();
  double* ReturnDistributionParameters();
  int Rank();
  BaseActionClass* Fire();
  double Rate();
}; // t_ExponentialActivityActivity

class t_DeterministicActivity:public Activity {
public:

  Place* StartDeterministic;
  short* StartDeterministic_Mobius_Mark;
  Place* EndDeterministic;
  short* EndDeterministic_Mobius_Mark;

  double* TheDistributionParameters;
  t_DeterministicActivity();
  ~t_DeterministicActivity();
  double Rate(){return 0;}
  bool Enabled();
  void LinkVariables();
  double Weight();
  bool ReactivationPredicate();
  bool ReactivationFunction();
  double SampleDistribution();
  double* ReturnDistributionParameters();
  int Rank();
  BaseActionClass* Fire();
  double DeterministicParamValue();
}; // t_DeterministicActivityActivity

class t_GaussianActivity:public Activity {
public:

  Place* StartGaussian;
  short* StartGaussian_Mobius_Mark;
  Place* EndGaussian;
  short* EndGaussian_Mobius_Mark;

  double* TheDistributionParameters;
  t_GaussianActivity();
  ~t_GaussianActivity();
  double Rate(){return 0;}
  bool Enabled();
  void LinkVariables();
  double Weight();
  bool ReactivationPredicate();
  bool ReactivationFunction();
  double SampleDistribution();
  double* ReturnDistributionParameters();
  int Rank();
  BaseActionClass* Fire();
  double NormalParamMean();
  double NormalParamVariance();
}; // t_GaussianActivityActivity

class t_UniformActivity:public Activity {
public:

  Place* StartUniform;
  short* StartUniform_Mobius_Mark;
  Place* EndUniform;
  short* EndUniform_Mobius_Mark;

  double* TheDistributionParameters;
  t_UniformActivity();
  ~t_UniformActivity();
  double Rate(){return 0;}
  bool Enabled();
  void LinkVariables();
  double Weight();
  bool ReactivationPredicate();
  bool ReactivationFunction();
  double SampleDistribution();
  double* ReturnDistributionParameters();
  int Rank();
  BaseActionClass* Fire();
  double UniformParamLowerBound();
  double UniformParamUpperBound();
}; // t_UniformActivityActivity

class t_GammaActivity:public Activity {
public:

  Place* StartGamma;
  short* StartGamma_Mobius_Mark;
  Place* EndGamma;
  short* EndGamma_Mobius_Mark;

  double* TheDistributionParameters;
  t_GammaActivity();
  ~t_GammaActivity();
  double Rate(){return 0;}
  bool Enabled();
  void LinkVariables();
  double Weight();
  bool ReactivationPredicate();
  bool ReactivationFunction();
  double SampleDistribution();
  double* ReturnDistributionParameters();
  int Rank();
  BaseActionClass* Fire();
  double GammaParamAlpha();
  double GammaParamBeta();
}; // t_GammaActivityActivity

class t_WeibullActivity:public Activity {
public:

  Place* StartWeibull;
  short* StartWeibull_Mobius_Mark;
  Place* EndWeibull;
  short* EndWeibull_Mobius_Mark;

  double* TheDistributionParameters;
  t_WeibullActivity();
  ~t_WeibullActivity();
  double Rate(){return 0;}
  bool Enabled();
  void LinkVariables();
  double Weight();
  bool ReactivationPredicate();
  bool ReactivationFunction();
  double SampleDistribution();
  double* ReturnDistributionParameters();
  int Rank();
  BaseActionClass* Fire();
  double WeibullParamAlpha();
  double WeibullParamBeta();
}; // t_WeibullActivityActivity

  //List of user-specified place names
  Place* StartExponential;
  Place* StartInstantaneous;
  Place* StartDeterministic;
  Place* StartGaussian;
  Place* StartUniform;
  Place* StartGamma;
  Place* StartWeibull;
  Place* EndExponential;
  Place* EndInstantaneous;
  Place* EndDeterministic;
  Place* EndGaussian;
  Place* EndUniform;
  Place* EndGamma;
  Place* EndWeibull;

  // Create instances of all actvities
  t_InstantaneousActivity t_Instantaneous;
  t_ExponentialActivity t_Exponential;
  t_DeterministicActivity t_Deterministic;
  t_GaussianActivity t_Gaussian;
  t_UniformActivity t_Uniform;
  t_GammaActivity t_Gamma;
  t_WeibullActivity t_Weibull;
  //Create instances of all groups 
  PreselectGroup ImmediateGroup;
  PostselectGroup t_InstantaneousGroup;

  Test01SAN();
  ~Test01SAN();
  void CustomInitialization();

  void assignPlacesToActivitiesInst();
  void assignPlacesToActivitiesTimed();
}; // end Test01SAN

#endif // Test01SAN_H_
