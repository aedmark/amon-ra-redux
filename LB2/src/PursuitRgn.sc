;;; Sierra Script 1.0 - (do not remove this comment)
(script# 94)
(include sci.sh)
(use Main)
(use Timer)
(use Game)
(use Obj)

(public
	PursuitRgn 0
	pursuitTimer 1
)

(local
	local0
)
(class PursuitRgn of Rgn
	(properties
		sel_20 {PursuitRgn}
		sel_142 0
		sel_40 0
		sel_214 -1
		sel_213 0
		sel_135 0
		sel_406 0
		sel_407 0
	)
	
	(method (sel_110)
		(super sel_110:)
		(cond 
			((< global87 5) (= local0 60))
			((< global87 10) (= local0 40))
			((<= global87 15) (= local0 20))
		)
		(if (not (HaveMouse)) (= local0 (* 2 local0)))
	)
	
	(method (sel_399 param1)
		(= sel_407 0)
		(= sel_406
			(proc999_5
				param1
				420
				430
				435
				440
				448
				450
				454
				460
				480
				490
				660
			)
		)
		(if (not sel_406) (pursuitTimer sel_111: sel_81:))
	)
	
	(method (sel_669)
		(pursuitTimer
			sel_137: (+ (pursuitTimer sel_137?) local0)
		)
	)
	
	(method (sel_670)
		(pursuitTimer
			sel_137: (- (pursuitTimer sel_137?) local0)
		)
	)
)

(instance pursuitTimer of Timer
	(properties
		sel_20 {pursuitTimer}
	)
	
	(method (sel_145)
		(global2 sel_403:)
	)
)
