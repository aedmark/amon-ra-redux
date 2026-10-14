;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 964)
(include sci.sh)
(use Motion)
(use System)

(class DPath of Motion
	(properties
		name {DPath}
		points 0
		value 0
	)

	(method (init param1 param2 &tmp temp0)
		(= points
			(if points
				points
			else
				(List new:)
			)
		)
		(if argc
			(= client param1)
			(for ((= temp0 0)) (<= temp0 (- argc 3)) ((++ temp0))
				(points add: [param2 temp0] [param2 (++ temp0)])
			)
			(if (<= temp0 (- argc 2))
				(= caller [param2 temp0])
			)
		)
		(if (points contains: -32768)
		else
			(points add: -32768)
		)
		(self setTarget:)
		(super init:)
		(if (not argc)
			(self doit:)
		)
	)

	(method (dispose)
		(if (IsObject points)
			(points dispose:)
		)
		(super dispose:)
	)

	(method (moveDone)
		(if (== (points at: value) -32768)
			(super moveDone:)
		else
			(self init:)
		)
	)

	(method (setTarget)
		(if (!= (points at: value) -32768)
			(= x (points at: value))
			(= y (points at: (++ value)))
			(++ value)
		)
	)
)
