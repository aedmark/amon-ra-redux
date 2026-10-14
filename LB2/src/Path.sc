;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 983)
(include sci.sh)
(use Print)
(use Motion)

(class Path of MoveTo
	(properties
		name {Path}
		intermediate 0
		value 0
	)

	(method (init param1 param2 param3)
		(= client param1)
		(= caller (if (>= argc 2) param2 else 0))
		(= intermediate (if (== argc 3) param3 else 0))
		(= value -1)
		(= x (client x:))
		(= y (client y:))
		(if (self atEnd:)
			(self moveDone:)
		else
			(self next:)
			(super init: client x y)
		)
	)

	(method (moveDone)
		(if (self atEnd:)
			(super moveDone:)
		else
			(if intermediate
				(intermediate cue: (/ value 2))
			)
			(self next:)
			(super init: client x y)
		)
	)

	(method (at &tmp [temp0 20])
		(Print addTextF: @temp0 {%s needs an 'at:' method.} name init:)
		(return 0)
	)

	(method (next)
		(= x (self at: (++ value)))
		(= y (self at: (++ value)))
	)

	(method (atEnd)
		(return
			(if (== (self at: (+ value 1)) -32768)
			else
				(== (self at: (+ value 2)) -32768)
			)
		)
	)
)

(class RelPath of Path
	(properties
		name {RelPath}
	)

	(method (next)
		(+= x (self at: (++ value)))
		(+= y (self at: (++ value)))
	)
)
