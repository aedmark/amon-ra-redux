;;; Sierra Script 1.0 - (do not remove this comment)
(script# 982)
(include sci.sh)
(use Main)

(public
	proc982_0 0
	proc982_1 1
	proc982_2 2
)

(procedure (proc982_0 param1)
	(return
		(not
			(if
				(and
					(<= 0 (param1 sel_1?))
					(<= (param1 sel_1?) 319)
					(<= 0 (- (param1 sel_0?) (param1 sel_82?)))
				)
				(<= (- (param1 sel_0?) (param1 sel_82?)) 189)
			else
				0
			)
		)
	)
)

(procedure (proc982_1 param1 theTheGEgo param3 param4 &tmp theGEgo temp1 temp2 temp3 temp4 theGEgoSel_1 theGEgoSel_0)
	(= theGEgo theTheGEgo)
	(= temp1 param3)
	(= temp2 param4)
	(if (< argc 4)
		(= temp2 32767)
		(if (< argc 3)
			(if (< argc 2) (= theGEgo gEgo))
			(= temp1
				(- 360 (if (== theGEgo gEgo) (* 2 global35) else 0))
			)
		)
	)
	(= temp3 (param1 sel_1?))
	(= temp4 (param1 sel_0?))
	(= theGEgoSel_1 (theGEgo sel_1?))
	(= theGEgoSel_0 (theGEgo sel_0?))
	(return
		(if (!= param1 theGEgo)
			(if
				(<
					(/ temp1 2)
					(Abs
						(proc982_2
							(GetAngle theGEgoSel_1 theGEgoSel_0 temp3 temp4)
							(theGEgo sel_55?)
						)
					)
				)
			else
				(<
					temp2
					(GetDistance
						theGEgoSel_1
						theGEgoSel_0
						temp3
						temp4
						gSel_413
					)
				)
			)
		else
			0
		)
	)
)

(procedure (proc982_2 param1 param2)
	(if (>= argc 2) (= param1 (- param1 param2)))
	(return
		(cond 
			((<= param1 -180) (+ param1 360))
			((> param1 180) (- param1 360))
			(else param1)
		)
	)
)
