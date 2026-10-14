;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(instance uEvt of Event
	(properties
		name {uEvt}
	)
)

(class User of Obj
	(properties
		name {User}
		alterEgo 0
		input 0
		theControls 0
		prevDir 0
		x -1
		y -1
		mapKeyToDir 1
		curEvent 0
	)

	(method (init)
		(= curEvent uEvt)
	)

	(method (doit)
		(curEvent
			type: 0
			message: 0
			modifiers: 0
			y: 0
			x: 0
			claimed: 0
			port: 0
		)
		(GetEvent evALL_EVENTS curEvent)
		(self handleEvent: curEvent)
	)

	(method (canControl param1)
		(if argc
			(= theControls param1)
			(= prevDir 0)
		)
		(return theControls)
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2 temp3)
		(= gMouseX (param1 x:))
		(= gMouseY (param1 y:))
		(= temp0 (param1 type:))
		(= temp2 (param1 modifiers:))
		(if temp0
			(= gLastEvent param1)
			(if mapKeyToDir
				(MapKeyToDir param1)
			)
			(if (== temp0 256)
				(= temp0 4)
				(= temp1 (if (& temp2 $0003) 27 else 13))
				(= temp2 0)
				(param1 type: temp0 message: temp1 modifiers: temp2)
			)
			(if (and gPrints (gPrints handleEvent: param1))
				(return 1)
			)
			(param1 localize:)
			(= temp0 (param1 type:))
			(= temp1 (param1 message:))
			(cond
				((& temp0 $0040)
					(cond
						((not (gUser canControl:)))
						((and gDirectionHandler (gDirectionHandler handleEvent: param1))
							(return 1)
						)
						(
							(and
								(or
									(and
										gTheIconBar
										(==
											(gTheIconBar curIcon:)
											(gTheIconBar walkIconItem:)
										)
									)
									(not gTheIconBar)
								)
								alterEgo
								theControls
								(gCast contains: alterEgo)
								(alterEgo handleEvent: param1)
							)
							(return 1)
						)
						(
							(and
								gPMouse
								input
								(or (not (& temp0 $0004)) (!= temp1 0))
								(gPMouse handleEvent: param1)
							)
							(return 1)
						)
					)
				)
				(
					(and
						(& temp0 $0004)
						(gUser canInput:)
						gKeyDownHandler
						(gKeyDownHandler handleEvent: param1)
					)
					(return 1)
				)
				(
					(and
						(& temp0 $0003)
						(gUser canInput:)
						gMouseDownHandler
						(gMouseDownHandler handleEvent: param1)
					)
					(return 1)
				)
			)
		)
		(if gTheIconBar
			(gTheIconBar handleEvent: param1)
		)
		(= temp0 (param1 type:))
		(= temp1 (param1 message:))
		(if (and input (& temp0 $4000))
			(cond
				((and (& temp0 $1000) gWalkHandler (gWalkHandler handleEvent: param1))
					(return 1)
				)
				(
					(and
						(& temp0 $1000)
						(gCast contains: alterEgo)
						theControls
						(alterEgo handleEvent: param1)
					)
					(return 1)
				)
				(gUseSortedFeatures
					(OnMeAndLowY init:)
					(gCast eachElementDo: 96 OnMeAndLowY param1)
					(gFeatures eachElementDo: 96 OnMeAndLowY param1)
					(gAddToPics eachElementDo: 96 OnMeAndLowY param1)
					(if
						(and
							(OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: param1)
						)
						(return 1)
					)
				)
				((gCast handleEvent: param1)
					(return 1)
				)
				((gFeatures handleEvent: param1)
					(return 1)
				)
			)
			(if (and (not (param1 claimed:)) (gRegions handleEvent: param1))
				(return 1)
			)
		)
		(if temp0
			(cond
				((gGame handleEvent: param1)
					(return 1)
				)
				((and gPrints (gPrints handleEvent: param1))
					(return 1)
				)
			)
		)
		(return 0)
	)

	(method (canInput param1)
		(if argc
			(= input param1)
		)
		(return input)
	)
)

(class Ego of Actor
	(properties
		name {Ego}
		signal 8192
		edgeHit 0
	)

	(method (init)
		(super init:)
		(if (not cycler)
			(self setCycle: Walk)
		)
	)

	(method (doit)
		(super doit:)
		(= edgeHit
			(cond
				((<= x 0) 4)
				((>= x 319) 2)
				((>= y 189) 3)
				((<= y (gCurRoom horizon:)) 1)
				(else 0)
			)
		)
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2)
		(= temp1 (param1 type:))
		(= temp2 (param1 message:))
		(cond
			((and script (script handleEvent: param1)) 1)
			((& temp1 $0040)
				(if (and (== (= temp0 temp2) 0) (& temp1 $0004))
					(param1 claimed:)
					(return)
				)
				(if
					(and
						(& temp1 $0004)
						(== temp0 (gUser prevDir:))
						(IsObject mover)
					)
					(= temp0 0)
				)
				(gUser prevDir: temp0)
				(self setDirection: temp0)
				(param1 claimed: 1)
			)
			((& temp1 $4000)
				(if (& temp1 $1000)
					(switch gUseObstacles
						(0
							(self
								setMotion:
									MoveTo
									(param1 x:)
									(+ (param1 y:) z)
							)
						)
						(1
							(self
								setMotion:
									PolyPath
									(param1 x:)
									(+ (param1 y:) z)
							)
						)
						(2
							(self
								setMotion:
									PolyPath
									(param1 x:)
									(+ (param1 y:) z)
									0
									0
							)
						)
					)
					(gUser prevDir: 0)
					(param1 claimed: 1)
				else
					(super handleEvent: param1)
				)
			)
			(else
				(super handleEvent: param1)
			)
		)
		(param1 claimed:)
	)

	(method (get param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			((gInventory at: [param1 temp0]) moveTo: self)
		)
	)

	(method (put param1 param2 &tmp temp0)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) -1 else param2)
			)
			(if (and gTheIconBar (== (gTheIconBar curInvIcon:) temp0))
				(gTheIconBar
					curInvIcon: 0
					disable: ((gTheIconBar useIconItem:) cursor: 999 yourself:)
				)
			)
		)
	)

	(method (has param1 &tmp temp0)
		(if (= temp0 (gInventory at: param1))
			(temp0 ownedBy: self)
		)
	)

	(method (setSpeed param1)
		(if argc
			(= moveSpeed (= cycleSpeed param1))
		)
		(return moveSpeed)
	)
)

(class OnMeAndLowY of Code
	(properties
		name {OnMeAndLowY}
		theObj 0
		lastY -1
	)

	(method (init)
		(= theObj 0)
		(= lastY -1)
	)

	(method (doit param1 param2)
		(if (and (param1 onMe: param2) (> (param1 y:) lastY))
			(= lastY ((= theObj param1) y:))
		)
	)
)
