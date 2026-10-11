;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use StopWalk)
(use Window)
(use Inventory)
(use User)

(class ego of Ego
	(properties
		sel_20 {ego}
		sel_213 1
		sel_214 19
		sel_301 180
		sel_2 800
		sel_584 0
	)

	(method (sel_350 param1)
		(if (== param1 -1)
			(super sel_350: &rest)
		else
			(super sel_350: param1 &rest)
			(gMessager sel_295: 2 4 0 0 0 19)
		)
	)

	(method (sel_351)
		(if (and (not (gUser sel_237:)) (== global121 (gTheIconBar sel_64: 5)))
			(= global121 (gTheIconBar sel_64: 0))
			(gGame sel_197: gWaitCursor)
		)
		(super sel_351: &rest)
	)

	(method (sel_585 param1)
		(= sel_2 (if argc param1 else 800))
		(self
			sel_155: -1
			sel_156: -1
			sel_63: -1
			sel_312: 0
			sel_161: StopWalk -1
			sel_338: 3 2
			sel_82: 0
			sel_15: -32768
			sel_316: 0
			sel_352: gSpeed
		)
	)

	(method (sel_586 &tmp temp0)
		(if (Inv sel_120: 353 gEgo)
			(= temp0 gSystemWindow)
			(= gSystemWindow SysWindow)
			(Inv sel_113: gEgo)
			(if (not (gTheIconBar sel_225:))
				(gTheIconBar sel_207: (gTheIconBar sel_64: 0) sel_233: 5)
				(if (& ((gTheIconBar sel_207:) sel_14:) $0004)
					(gTheIconBar sel_231:)
				)
				(gGame sel_197: ((gTheIconBar sel_207:) sel_33:))
			)
			(= gSystemWindow temp0)
			(gNarrator sel_540: 0 sel_20: {Narrator})
		else
			(gMessager sel_295: 1 0 1 0 0 19)
		)
	)
)
