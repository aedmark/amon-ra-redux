;;; Sierra Script 1.0 - (do not remove this comment)
(script# 977)
(include sci.sh)
(use Main)
(use StopWalk)
(use n982)
(use Cycle)
(use Obj)


(local
	[local0 8] = [2 6 4 0 3 5 1 7]
	[local8 8] = [3 6 0 4 2 5 1 7]
)
(class Grooper of Code
	(properties
		sel_20 {Grooper}
		sel_42 0
		sel_453 0
		sel_454 0
		sel_143 0
	)
	
	(method (sel_57 theSel_42 param2 theSel_143 param4 &tmp temp0 temp1)
		(if (not sel_42) (= sel_42 theSel_42))
		(if (& (sel_42 sel_14?) $0800)
			(if sel_143 (sel_143 sel_145:))
			(= sel_143 0)
			(return)
		)
		(if (>= argc 3) (= sel_143 theSel_143))
		(= temp1 (if (< (NumLoops sel_42) 8) 4 else 8))
		(if
			(or
				(not (gSel_561 sel_122: sel_42))
				(and (>= argc 4) param4)
			)
			(sel_42
				sel_3:
					[local8 (*
						(if (== temp1 4) 2 else 1)
						(/
							(proc999_1 (+ (sel_42 sel_55?) (/ 180 temp1)) 360)
							(/ 360 temp1)
						)
					)]
			)
			(if sel_143 (sel_143 sel_145:))
			(= sel_143 0)
			(return)
		)
		(= temp0
			(if
				(and
					(== (sel_42 sel_3?) (- (NumLoops sel_42) 1))
					((sel_42 sel_245?) sel_114: StopWalk)
					(== ((sel_42 sel_245?) sel_452?) -1)
				)
				[local0 (sel_42 sel_4?)]
			else
				[local0 (sel_42 sel_3?)]
			)
		)
		(if sel_454 (sel_454 sel_111:) (= sel_454 0))
		(if
			(and
				(IsObject sel_453)
				(or
					(sel_453 sel_115: Grycler)
					(not ((sel_42 sel_245?) sel_115: Grycler))
				)
			)
			(sel_453 sel_111:)
			(= sel_453 0)
		)
		(if (not sel_453) (= sel_453 (sel_42 sel_245?)))
		(if
			(and
				(sel_42 sel_245?)
				((sel_42 sel_245?) sel_115: Grycler)
			)
			((sel_42 sel_245?) sel_111:)
		)
		(= sel_454 (sel_42 sel_56?))
		(sel_42
			sel_245: 0
			sel_56: 0
			sel_312: 0
			sel_161: Grycler self temp0
		)
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
		(if sel_42 (sel_42 sel_59: 0))
		(super sel_111:)
	)
	
	(method (sel_145 &tmp theSel_143)
		(if (not (IsObject (sel_42 sel_56?)))
			(sel_42 sel_56: sel_454)
		)
		(if (IsObject sel_453) (sel_42 sel_245: sel_453))
		(= theSel_143 sel_143)
		(= sel_143 (= sel_454 (= sel_453 0)))
		(if theSel_143 (theSel_143 sel_145: &rest))
	)
)

(class Grycler of Cycle
	(properties
		sel_20 {Grycler}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_455 0
		sel_456 0
	)
	
	(method (sel_110 param1 theSel_143 theSel_455)
		(super sel_110: param1)
		(= sel_143 theSel_143)
		(= sel_456 (if (< (NumLoops sel_42) 8) 4 else 8))
		(= sel_239
			(-
				(proc999_0
					(proc982_2 (* theSel_455 45) (param1 sel_55?))
				)
			)
		)
		(= sel_455 theSel_455)
		(if (self sel_457:)
			(if
				(and
					(((sel_42 sel_59?) sel_453?) sel_114: StopWalk)
					(== (((sel_42 sel_59?) sel_453?) sel_452?) -1)
				)
				(sel_42 sel_3: [local8 sel_455])
			)
			(self sel_242:)
		)
	)
	
	(method (sel_57)
		(sel_42 sel_3: (self sel_241:))
		(if (self sel_457:) (self sel_242:))
	)
	
	(method (sel_241)
		(return
			(if
				(or
					(< (Abs (- gSel_45 sel_158)) (sel_42 sel_244?))
					(self sel_457:)
				)
				(sel_42 sel_3?)
			else
				(= sel_158 gSel_45)
				(= sel_455 (+ sel_455 (* sel_239 (/ 8 sel_456))))
				(= sel_455 (proc999_1 sel_455 8))
				[local8 sel_455]
			)
		)
	)
	
	(method (sel_242)
		(= global37 (= sel_240 1))
	)
	
	(method (sel_457)
		(return
			(<
				(Abs (proc982_2 (* sel_455 45) (sel_42 sel_55?)))
				(+ (/ 180 sel_456) 1)
			)
		)
	)
)
