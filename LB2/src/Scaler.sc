;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 935)
(include sci.sh)
(use Print)
(use System)

(class Scaler of Code
	(properties
		name {Scaler}
		client 0
		frontY 190
		backY 0
		frontSize 100
		backSize 0
		slopeNum 0
		slopeDen 0
		const 0
	)

	(method (init param1 param2 param3 param4 param5)
		(if argc
			(= client param1)
			(= frontSize param2)
			(= backSize param3)
			(= frontY param4)
			(= backY param5)
		)
		(= slopeNum (- frontSize backSize))
		(if (not (= slopeDen (- frontY backY)))
			(Prints {<Scaler> frontY cannot be equal to backY})
			(return 0)
		)
		(= const (- backSize (/ (* slopeNum backY) slopeDen)))
		(return (self doit:))
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((< (= temp0 (client y:)) backY)
				(= temp1 backSize)
			)
			((> temp0 frontY)
				(= temp1 frontSize)
			)
			(else
				(= temp1 (+ (/ (* slopeNum temp0) slopeDen) const))
			)
		)
		(= temp1 (/ (* temp1 128) 100))
		(client scaleX: temp1 scaleY: temp1)
	)
)
