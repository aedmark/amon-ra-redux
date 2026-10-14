;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 923)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(class Inset of Code
	(properties
		name {Inset}
		picture 0
		anOverlay 0
		style 100
		view 0
		loop 0
		cel 0
		x 0
		y 0
		priority 14
		register 0
		hideTheCast 0
		caller 0
		owner 0
		script 0
		oldCast 0
		oldFeatures 0
		oldATPs 0
		oldMH 0
		oldKH 0
		oldDH 0
		oldWH 0
		oldObstacles 0
		oldStyle 0
		inset 0
		disposeNotOnMe 0
		modNum -1
		noun 0
		insetView 0
	)

	(method (init param1 param2 param3)
		(= owner param2)
		(owner inset: self)
		(= register param3)
		(= caller param1)
		(if (and (not picture) hideTheCast)
			(self hideCast: 1)
		)
		(= oldCast gCast)
		(= oldFeatures gFeatures)
		(= oldATPs gAddToPics)
		(= oldMH gMouseDownHandler)
		(= oldKH gKeyDownHandler)
		(= oldDH gDirectionHandler)
		(= oldWH gWalkHandler)
		(= oldObstacles (gCurRoom obstacles:))
		(gCurRoom obstacles: ((List new:) add: yourself:))
		((= gCast (EventHandler new:)) name: {newCast} add:)
		((= gFeatures (EventHandler new:))
			name: {newFeatures}
			add: self
		)
		((= gAddToPics (EventHandler new:)) name: {newATPs} add:)
		((= gMouseDownHandler (EventHandler new:)) name: {newMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {newKH} add: self)
		((= gDirectionHandler (EventHandler new:)) name: {newDH} add: self)
		((= gWalkHandler (EventHandler new:)) name: {newWH} add:)
		(gTheDoits add: self)
		(self drawInset:)
	)

	(method (doit)
		(if script
			(script doit:)
		)
		(if (not hideTheCast)
			(Animate (oldCast elements:) 0)
		)
	)

	(method (dispose param1 &tmp temp0)
		(if inset
			(inset dispose: 0)
		)
		(gFeatures delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gWalkHandler delete: self)
		(gTheDoits delete: self)
		(gCast eachElementDo: 111 eachElementDo: 81 release: dispose:)
		(gAddToPics dispose:)
		(gFeatures dispose:)
		(gMouseDownHandler dispose:)
		(gKeyDownHandler dispose:)
		(gDirectionHandler dispose:)
		(gWalkHandler dispose:)
		((gCurRoom obstacles:) dispose:)
		(owner inset: 0)
		(if (== owner gCurRoom)
			(gTheIconBar enable: 7)
		)
		(if (or (not argc) param1)
			(self refresh:)
		)
		(gCurRoom obstacles: oldObstacles)
		(= gCast oldCast)
		(= gAddToPics oldATPs)
		(= gFeatures oldFeatures)
		(= gMouseDownHandler oldMH)
		(= gKeyDownHandler oldKH)
		(= gDirectionHandler oldDH)
		(= gWalkHandler oldWH)
		(if (or (not argc) param1)
			(gAddToPics doit:)
		)
		(if (and (not picture) hideTheCast)
			(self hideCast: 0)
		)
		(if (and (or (not argc) param1) caller)
			(= temp0 caller)
			(= caller 0)
			(temp0 cue:)
		)
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(= script (if argc param1 else 0))
		(if script
			(script init: self &rest)
		)
	)

	(method (handleEvent param1 &tmp [temp0 2])
		(cond
			((and inset (inset handleEvent: param1)) 0)
			((& (param1 type:) $4000)
				(cond
					((self onMe: param1)
						(param1 claimed: 1)
						(self doVerb: (param1 message:))
					)
					(disposeNotOnMe
						(param1 claimed: 1)
						(self dispose:)
					)
					(else
						(return 0)
					)
				)
			)
		)
	)

	(method (doVerb param1)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun param1 0 1))
			(gMessager say: noun param1 0 0 0 modNum)
		else
			(gDoVerbCode doit: param1 self)
		)
	)

	(method (hideCast param1 &tmp temp0 temp1)
		(= temp0 0)
		(= temp1 (if param1 1000 else -1000))
		(while (< temp0 (gCast size:))
			((gCast at: temp0)
				z: (+ ((gCast at: temp0) z:) temp1)
			)
			(++ temp0)
		)
		(Animate (gCast elements:) 0)
	)

	(method (drawInset)
		(if (> picture 0)
			(DrawPic
				picture
				(if anOverlay 100 else style)
				(if anOverlay 0 else 1)
				global40
			)
		)
		(if view
			(= insetView
				((inView new:)
					view: view
					loop: loop
					cel: cel
					x: x
					y: y
					setPri: priority
					ignoreActors: 1
					init:
					yourself:
				)
			)
		)
	)

	(method (restore)
		(self drawInset:)
		(if inset
			((inset oldATPs:) doit:)
			(inset restore:)
		)
	)

	(method (refresh)
		(if view
			(DrawPic (gCurRoom picture:) 100)
		else
			(DrawPic (gCurRoom picture:) style)
		)
		(gCurRoom style: oldStyle)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0 global40)
		)
		(if (gCurRoom inset:)
			((gCurRoom inset:) restore:)
		)
	)

	(method (setInset param1 param2 param3)
		(if inset
			(inset dispose:)
		)
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(if view
			(return (insetView onMe: param1 param2))
		else
			(return 1)
		)
	)
)

(instance inView of View
	(properties
		name {inView}
	)

	(method (handleEvent)
		(return 0)
	)
)
