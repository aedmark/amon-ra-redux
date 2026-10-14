;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 939)
(include sci.sh)
(use Motion)

(class Osc of Cycle
	(properties
		name {Osc}
		howManyCycles -1
	)

	(method (init param1 param2 param3)
		(if (>= argc 2)
			(= howManyCycles param2)
			(if (>= argc 3)
				(= caller param3)
			)
		)
		(super init: param1)
	)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) (client lastCel:)) (< temp0 0))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(if howManyCycles
			(client cel: (self nextCel:))
			(if (> howManyCycles 0)
				(-- howManyCycles)
			)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)
