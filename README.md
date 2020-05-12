# CHESS State-Based Analysis

This software is part of **PolarSys CHESS**, an open source methodology and tool for the development of high-integrity embedded systems.
The CHESS methodology was devised and implemented initially in the [CHESS](http://chess-project.org/) project, later extended in the [CONCERTO](http://concerto-project.eu/) project, and then further developed within other projects.
The toolset, which was formerly known as _"The CHESS Framework"_, is an integrated collection of Eclipse plugins, now forming a subproject of Eclipse PolarSys. Since then, we call it PolarSys CHESS. 

## PolarSys CHESS

[PolarSys](http://polarsys.org/) is an Eclipse Working Group focusing on the creation and support of open source tools for the development of embedded systems.
Most of the original CHESS Framework has been released as open source within the PolarSys umbrella, constituting the *PolarSys CHESS Eclipse Project*.
Further information can be found on the [Official Website](http://polarsys.org/chess/) and on the [Eclipse Project Page](https://www.polarsys.org/projects/polarsys.chess/).

## Usage

This plugin performs **Quantitative Dependability Analysis** using a variant of the **Stochastic Petri Nets** formalism. It is _not_ a standalone program, but requires the full installation of [PolarSys CHESS](http://polarsys.org/chess/).

Usage instructions are available [in the wiki](https://github.com/montex/CHESS-SBA/wiki). Further information can be found in the following documents, as well as in the [scientific publications](#publications) related to this plugin.

* [CHESS Toolset User Guide][1] (June 2016)  
_The official user guide of the complete CHESS framework._
* [CHESS-SBA Training Video][2] and [Training Slides][2a] (June 2016)  
_A training video of CHESS-SBA, produced within the CONCERTO project, and the corresponding slides._
* [CONCERTO D5.6 Use Case Evaluations - Final Version][3] (May 2016)  
_Deliverable 5.6 of the CONCERTO project, contains evaluations of the CHESS framework by industrial user and experts._
* [CONCERTO D3.3 Design and Implementation of Analysis Methods for Non-Functional Properties - Final Version][4] (November 2015)  
_Deliverable 3.3 of the CONCERTO project, contains technical details on the implementation and usage of CHESS-SBA._
* [CHESS D3.2.2 Transformations and Analysis Support to Dependability][5] (December 2011)  
_Deliverable 3.2.2 of the CHESS project, contains technical details on the implementation and usage of CHESS-SBA._

[1]: http://polarsys.org/chess/publis/CHESSToolset_UserGuide.pdf
[2]: http://3sei.com/concerto/2016%20CHESS%20UNIFI%20Dependability%20Analysis%20QA.f4v
[2a]: https://github.com/montex/CHESS-SBA/wiki/files/CHESS-SBA-Training.pdf
[3]: http://api.ning.com/files/C*P8XcSSeqc3MxUI2YKOEFiInob-K*l89xHB9MNBm10O3GxE8eaNjU0PbPmAtbqGk-JiQ1spjGRLr-xPptE5IwqiWiEs7Wbe/D5.6UsecaseEvaluationsFinalVersionUpdate.pdf
[4]: http://api.ning.com/files/HrJMLaNSVNhJXvecadVmzHDCs4n9OypBKROzgpm14JdNzAz19R0eGzNpCHwfDz7rOFbdtyoC*FVLbbsaKDfTnG3t8NnKWXjU/D3.3DesignandimplementationofanalysismethodsfornonfunctionalpropertiesFinalversion.pdf
[5]: http://api.ning.com/files/cUeizBqjmZoDh3wZimWhgoO5IEzWZHEHUNNxQUoqeH2rOvyBJd404Jq0EYFSYjIfoy1CVBtCFJOiRTPi1E2z2rChNtFiz9yh/D3.2.2Transformationsandanalysissupporttodependabilityw.pdf

## Contributors

The tool has been developed at the [Resilient Computing Lab](http://rcl.dsi.unifi.it), University of Firenze, Italy, and it is released under the EPL license.
Please see the [LICENSE](LICENSE) and [COPYRIGHT](COPYRIGHT) files for more information.

For any question, info, or suggestion feel free to contact us:
* Leonardo Montecchi <leonardo@ic.unicamp.br>
* Paolo Lollini <lollini@unifi.it>

## Publications
* L. Bressan, A. L. de Oliveira, L. Montecchi, B. Gallina. "[A Systematic Process for Applying the CHESS Methodology in the Creation of Certifiable Evidence](https://ieeexplore.ieee.org/document/8530760)".
In: 14th European Dependable Computing Conference (EDCC 2018). Iași, Romania, September 10-14, 2018. pp. 49-56.

* L. Montecchi, B. Gallina. "[SafeConcert: a Metamodel for a Concerted Safety Modeling of Socio-Technical Systems](https://link.springer.com/chapter/10.1007/978-3-319-64119-5_9)".
In: 5th International Symposium on Model-Based Safety and Assessment (IMBSA 2017). Trento, Italy, September 11, 2017. pp. 129-144.

* L. Montecchi, P. Lollini, A. Bondavalli. "[A Reusable Modular Toolchain for Automated Dependability Evaluation](https://dl.acm.org/citation.cfm?id=2631882)".
In: 7th International Conference on Performance Evaluation Methodologies and Tools (VALUETOOLS 2013). Torino, Italy, December 10, 2013. pp. 298-303. 

* L. Montecchi, P. Lollini, A. Bondavalli. "[Towards a MDE Transformation Workflow for Dependability Analysis](http://ieeexplore.ieee.org/document/5773390/)".
In: 16th IEEE International Conference on Engineering of Complex Computer Systems (ICECCS 2011). Las Vegas, NV, USA, April 29, 2011. pp. 157-166. 

* L. Montecchi, P. Lollini, A. Bondavalli. "[Dependability Concerns in Model-Driven Engineering](http://ieeexplore.ieee.org/document/5753535/)". In: 2nd IEEE International Workshop on Object/Component/Service-Oriented Real-Time Networked Ultra-Dependable Systems (WORNUS 2011). Newport Beach, CA, USA, March 28, 2011. pp. 254-263.
