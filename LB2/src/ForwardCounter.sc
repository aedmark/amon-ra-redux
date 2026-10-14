;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 956)
(include sci.sh)
(use Motion)

(class ForwardCounter of Fwd
	(properties
		name {ForwardCounter}
		count 0
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(if (>= argc 2)
			(= count param2)
			(if (>= argc 3)
				(= caller param3)
			)
		)
	)

	(method (cycleDone)
		(if (-- count)
			(super cycleDone:)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)
