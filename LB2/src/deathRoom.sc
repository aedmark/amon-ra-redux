;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use eRS)
(use Print)

(public
	deathRoom 0
)

(instance deathRoom of LBRoom
	(properties
		sel_20 {deathRoom}
		sel_408 780
		sel_340 120
		sel_409 350
	)

	(method (sel_110 &tmp temp0 temp1)
		(super sel_110:)
		(gGameMusic1 sel_40: 99 sel_99: 1 sel_3: 1 sel_39:)
		(if (== global145 15)
			(= temp1 86)
		else
			(= temp1 62)
		)
		(= temp0 (+ global145 1))
		(Animate (gCast sel_24:) 0)
		(repeat
			(switch
				(Print
					sel_198: 1 45 temp0 0 100 0
					sel_206: 99 0 global145 0 0
					sel_205: 1 {Restore} 0 temp1
					sel_205: 2 {Restart} 70 temp1
					sel_205: 3 {____Quit____} 140 temp1
					sel_110:
				)
				(1
					(gGame sel_76:)
				)
				(2
					(gGame sel_101:)
				)
				(3
					(= gQuit 1)
					(break)
				)
			)
		)
	)
)
