;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 933)
(include sci.sh)
(use Main)
(use System)

(class PseudoMouse of Code
	(properties
		name {PseudoMouse}
		cursorInc 2
		minInc 2
		maxInc 20
		prevDir 0
		joyInc 5
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (gLastEvent x:))
		(= temp1 (gLastEvent y:))
		(switch prevDir
			(1
				(-= temp1 cursorInc)
			)
			(2
				(+= temp0 cursorInc)
				(-= temp1 cursorInc)
			)
			(3
				(+= temp0 cursorInc)
			)
			(4
				(+= temp0 cursorInc)
				(+= temp1 cursorInc)
			)
			(5
				(+= temp1 cursorInc)
			)
			(6
				(-= temp0 cursorInc)
				(+= temp1 cursorInc)
			)
			(7
				(-= temp0 cursorInc)
			)
			(8
				(-= temp0 cursorInc)
				(-= temp1 cursorInc)
			)
		)
		(gGame setCursor: gTheCursor 1 temp0 temp1)
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2)
		(= temp0 (param1 type:))
		(= temp1 (param1 message:))
		(= temp2 (param1 modifiers:))
		(if (& temp0 $0040)
			(if (or (not gTheIconBar) (!= (gTheIconBar curIcon:) (gTheIconBar walkIconItem:)))
				(= prevDir temp1)
			else
				(return 0)
			)
			(= cursorInc
				(if (& temp0 $0004)
					(if (& temp2 $0003) minInc else maxInc)
				else
					joyInc
				)
			)
			(cond
				((& temp0 $0004)
					(if prevDir
						(self doit:)
					else
						(return (param1 claimed: 0))
					)
				)
				(prevDir
					(self start:)
				)
				(else
					(self stop:)
				)
			)
			(return (param1 claimed: 1))
		else
			0
		)
	)

	(method (start param1)
		(if argc
			(= prevDir param1)
		)
		(gTheDoits add: self)
	)

	(method (stop)
		(= prevDir 0)
		(gTheDoits delete: self)
	)
)
