;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use PolyPath)
(use Game)
(use User)
(use System)

(public
	eRS 0
)

(procedure (localproc_0)
	(cond
		((< (gEgo sel_1:) 0)
			(gEgo sel_1: (+ 0 (* (gEgo sel_51:) 2)))
		)
		((> (gEgo sel_1:) 319)
			(gEgo sel_1: (- 319 (* (gEgo sel_51:) 2)))
		)
	)
)

(procedure (localproc_1)
	(cond
		((< (gEgo sel_0:) (gCurRoom sel_340:))
			(gEgo sel_0: (+ (gCurRoom sel_340:) (* (gEgo sel_52:) 2)))
		)
		((> (gEgo sel_0:) 189)
			(gEgo sel_0: (- 189 (* (gEgo sel_52:) 2)))
		)
	)
)

(class LBRoom of Rm
	(properties
		sel_20 {LBRoom}
		sel_340 15
	)

	(method (sel_110 param1 &tmp temp0 temp1 [temp2 2])
		(= sel_40 gCurRoomNum)
		(= gPerspective sel_413)
		(if sel_408
			(self sel_417: sel_408)
		)
		(cond
			((not (gCast sel_122: gEgo)) 0)
			(sel_142 0)
			((not ((User sel_341:) sel_349:)) 0)
			((OneOf sel_28 11 12 13 14)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User sel_341:) sel_2:)
								((User sel_341:) sel_3:)
								((User sel_341:) sel_4:)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(/
							(CelHigh
								((User sel_341:) sel_2:)
								((User sel_341:) sel_3:)
								((User sel_341:) sel_4:)
							)
							2
						)
					)
				)
				(switch ((User sel_341:) sel_349:)
					(1
						((User sel_341:) sel_0: 188)
					)
					(4
						((User sel_341:) sel_1: (- 319 temp0))
					)
					(3
						((User sel_341:) sel_0: (+ sel_340 temp1))
					)
					(2
						((User sel_341:) sel_1: (+ 0 temp0))
					)
				)
				((User sel_341:) sel_349: 0)
			)
			(else
				(if (not argc)
					(= param1 0)
				)
				(self sel_146: eRS param1 gPrevRoomNum)
			)
		)
		(if (gEgo sel_322:)
			((gEgo sel_322:) sel_57:)
		)
	)

	(method (sel_57 &tmp temp0)
		(cond
			(sel_142
				(sel_142 sel_57:)
			)
			((!= gCurRoomNum gNewRoomNum) 0)
			((not (gCast sel_122: gEgo)) 0)
			(
				(switch (= temp0 ((User sel_341:) sel_349:))
					(1 sel_409)
					(2 sel_410)
					(3 sel_411)
					(4 sel_412)
				)
				(self sel_146: lRS 0 temp0)
			)
		)
	)

	(method (sel_300 param1)
		(if (not (super sel_300: param1))
			(proc0_6 self param1)
		)
	)

	(method (sel_422)
		(super sel_422: &rest)
	)
)

(instance lRS of Script
	(properties
		sel_20 {lRS}
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(gGame sel_587:)
				(= temp1
					(CelWide (gEgo sel_2:) (gEgo sel_3:) (gEgo sel_4:))
				)
				(= temp0
					(CelHigh (gEgo sel_2:) (gEgo sel_3:) (gEgo sel_4:))
				)
				(switch sel_141
					(1
						(gCurRoom sel_399: (gCurRoom sel_409:))
					)
					(3
						(gEgo
							sel_312:
								PolyPath
								(gEgo sel_1:)
								(+ 189 temp0)
								self
						)
						(= sel_141 (gCurRoom sel_411:))
					)
					(2
						(gEgo
							sel_312:
								PolyPath
								(+ 319 temp1)
								(gEgo sel_0:)
								self
						)
						(= sel_141 (gCurRoom sel_410:))
					)
					(4
						(gEgo
							sel_312: PolyPath (- 0 temp1) (gEgo sel_0:) self
						)
						(= sel_141 (gCurRoom sel_412:))
					)
				)
			)
			(1
				(gEgo sel_102:)
				(= sel_136 2)
			)
			(2
				(gCurRoom sel_399: sel_141)
			)
		)
	)
)

(instance eRS of Script
	(properties
		sel_20 {eRS}
	)

	(method (sel_144 param1 &tmp temp0 temp1)
		(switch (= sel_29 param1)
			(0
				(= sel_136 0)
				(if (gUser sel_237:)
					(gGame sel_587:)
				)
				(= temp0
					(CelHigh (gEgo sel_2:) (gEgo sel_3:) (gEgo sel_4:))
				)
				(= temp1
					(CelWide (gEgo sel_2:) (gEgo sel_3:) (gEgo sel_4:))
				)
				(switch sel_141
					((sel_42 sel_409:)
						(localproc_0)
						(gEgo
							sel_0: (+ (gCurRoom sel_340:) (gEgo sel_52:))
						)
						(= sel_136 1)
					)
					((sel_42 sel_411:)
						(localproc_0)
						(gEgo
							sel_0: (+ 189 temp0)
							sel_312:
								PolyPath
								(gEgo sel_1:)
								(- 189 (* (gEgo sel_52:) 2))
								self
						)
					)
					((sel_42 sel_410:)
						(localproc_1)
						(gEgo
							sel_1: (+ 319 (/ temp1 2))
							sel_312:
								PolyPath
								(- 319 (* (gEgo sel_51:) 2))
								(gEgo sel_0:)
								self
						)
					)
					((sel_42 sel_412:)
						(localproc_1)
						(gEgo
							sel_1: (- 0 (/ temp1 2))
							sel_312:
								PolyPath
								(+ 0 (* (gEgo sel_51:) 2))
								(gEgo sel_0:)
								self
						)
					)
					(else
						(= sel_136 1)
					)
				)
			)
			(1
				(gGame sel_588: 1)
				(self sel_111:)
			)
		)
	)
)
