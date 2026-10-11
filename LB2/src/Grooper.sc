;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 977)
(include sci.sh)
(use Main)
(use StopWalk)
(use Sight)
(use Motion)
(use System)

(local
	[trans1 8] = [2 6 4 0 3 5 1 7]
	[trans2 8] = [3 6 0 4 2 5 1 7]
)

(class Grooper of Code
	(properties
		sel_20 {Grooper}
		sel_42 0
		sel_453 0
		sel_454 0
		sel_143 0
	)

	(method (sel_57 param1 param2 param3 param4 &tmp temp0 temp1)
		(if (not sel_42)
			(= sel_42 param1)
		)
		(if (& (sel_42 sel_14:) $0800)
			(if sel_143
				(sel_143 sel_145:)
			)
			(= sel_143 0)
			(return)
		)
		(if (>= argc 3)
			(= sel_143 param3)
		)
		(= temp1 (if (< (NumLoops sel_42) 8) 4 else 8))
		(if (or (not (gCast sel_122: sel_42)) (and (>= argc 4) param4))
			(sel_42
				sel_3:
					[trans2
						(*
							(if (== temp1 4) 2 else 1)
							(/
								(umod
									(+ (sel_42 sel_55:) (/ 180 temp1))
									360
								)
								(/ 360 temp1)
							)
						)
					]
			)
			(if sel_143
				(sel_143 sel_145:)
			)
			(= sel_143 0)
			(return)
		)
		(= temp0
			(if
				(and
					(== (sel_42 sel_3:) (- (NumLoops sel_42) 1))
					((sel_42 sel_245:) sel_114: StopWalk)
					(== ((sel_42 sel_245:) sel_452:) -1)
				)
				[trans1 (sel_42 sel_4:)]
			else
				[trans1 (sel_42 sel_3:)]
			)
		)
		(if sel_454
			(sel_454 sel_111:)
			(= sel_454 0)
		)
		(if
			(and
				(IsObject sel_453)
				(or
					(sel_453 sel_115: Grycler)
					(not ((sel_42 sel_245:) sel_115: Grycler))
				)
			)
			(sel_453 sel_111:)
			(= sel_453 0)
		)
		(if (not sel_453)
			(= sel_453 (sel_42 sel_245:))
		)
		(if (and (sel_42 sel_245:) ((sel_42 sel_245:) sel_115: Grycler))
			((sel_42 sel_245:) sel_111:)
		)
		(= sel_454 (sel_42 sel_56:))
		(sel_42 sel_245: 0 sel_56: 0 sel_312: 0 sel_161: Grycler self temp0)
	)

	(method (sel_111)
		(if (IsObject sel_453)
			(sel_453 sel_111:)
			(= sel_453 0)
		)
		(if (IsObject sel_454)
			(sel_454 sel_111:)
			(= sel_454 0)
		)
		(if sel_42
			(sel_42 sel_59: 0)
		)
		(super sel_111:)
	)

	(method (sel_145 &tmp temp0)
		(if (not (IsObject (sel_42 sel_56:)))
			(sel_42 sel_56: sel_454)
		)
		(if (IsObject sel_453)
			(sel_42 sel_245: sel_453)
		)
		(= temp0 sel_143)
		(= sel_143 (= sel_454 (= sel_453 0)))
		(if temp0
			(temp0 sel_145: &rest)
		)
	)
)

(class Grycler of Cycle
	(properties
		sel_20 {Grycler}
		sel_455 0
		sel_456 0
	)

	(method (sel_110 param1 param2 param3)
		(super sel_110: param1)
		(= sel_143 param2)
		(= sel_456 (if (< (NumLoops sel_42) 8) 4 else 8))
		(= sel_239 (- (sign (AngleDiff (* param3 45) (param1 sel_55:)))))
		(= sel_455 param3)
		(if (self sel_457:)
			(if
				(and
					(((sel_42 sel_59:) sel_453:) sel_114: StopWalk)
					(== (((sel_42 sel_59:) sel_453:) sel_452:) -1)
				)
				(sel_42 sel_3: [trans2 sel_455])
			)
			(self sel_242:)
		)
	)

	(method (sel_57)
		(sel_42 sel_3: (self sel_241:))
		(if (self sel_457:)
			(self sel_242:)
		)
	)

	(method (sel_241)
		(return
			(if
				(or
					(< (Abs (- gGameTime sel_158)) (sel_42 sel_244:))
					(self sel_457:)
				)
				(sel_42 sel_3:)
			else
				(= sel_158 gGameTime)
				(+= sel_455 (* sel_239 (/ 8 sel_456)))
				(= sel_455 (umod sel_455 8))
				[trans2 sel_455]
			)
		)
	)

	(method (sel_242)
		(= gDoMotionCue (= sel_240 1))
	)

	(method (sel_457)
		(return
			(<
				(Abs (AngleDiff (* sel_455 45) (sel_42 sel_55:)))
				(+ (/ 180 sel_456) 1)
			)
		)
	)
)
