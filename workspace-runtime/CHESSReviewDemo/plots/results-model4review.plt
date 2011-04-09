set terminal svg

set xlabel 'Time t (hours)' 
set ylabel 'R(t)' 

set xtics format "%.0e"

set title "Reliability of component \"Receiver_impl_inst\"\r\nin platform \"hwsystem_instanceSpecification\""

set output "model4review-p1.0.svg"
plot './results-model4review.txt' u 1:3 ev :::0::0 t 'Reliability_Receiver_impl_inst(t)' w lp

set yrange [0:1.1]
set key bottom left
set output "model4review-p0.01.svg"
plot './results-model4review.txt' u 1:3 ev :::0::0 t 'p=1.0' w lp,\
	 './results-model4review.txt' u 1:3 ev :::1::1 t 'p=0.01' w lp

