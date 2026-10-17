;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Inset)
(use Feature)
(use User)
(use Actor)
(use System)

(public
	inNotebook 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

; PLAY-008: notebook topics the character being asked has already answered are drawn in grey.
; The asked grid is one word per topic from global296, one bit per character (proc27_0, proc27_1),
; cleared at each act break except bits 10 and 11 (proc27_2). Characters set global178 to their bit + 1
; just before opening the notebook. The chosen topic waits in global179 (grid index), global180 (bit + 1),
; and global181 (act) until the notebook next opens, so each character's own first-time/repeat check
; runs before the bit is set.
(procedure (localproc_2 param1)
	; Grid index for topic param1, or -1. A person's topic moves to the word the characters' own
	; murder-reaction checks use once that death is known, so it reopens for everyone.
	(cond
		((and (<= 257 param1) (<= param1 272))
			(cond
				; Sgt. O'Flaherty's answer about O'Riley changes once Laura has read O'Riley's
				; folder (flag 43), so the topic moves to the unused index 24 and reopens.
				((and (== param1 260) (IsFlag 43)) (return 24))
				((and (== param1 258) (IsFlag 134)) (return 68))
				((and (== param1 259) (or (IsFlag 171) (IsFlag 12))) (return 67))
				((and (== param1 264) (or (IsFlag 143) (IsFlag 72))) (return 70))
				((and (== param1 266) (or (IsFlag 161) (IsFlag 68))) (return 71))
				((and (== param1 267) (or (IsFlag 158) (IsFlag 67))) (return 69))
				((and (== param1 269) (or (IsFlag 69) (IsFlag 165) (IsFlag 166))) (return 66))
				(else (return (- param1 257)))
			)
		)
		((and (<= 513 param1) (<= param1 520))
			(return (- param1 497))
		)
		((and (<= 769 param1) (<= param1 803))
			(if (and (== param1 780) (or (IsFlag 155) (IsFlag 22) (gEgo has: 11)))
				(return 72)
			)
			(return (- param1 744))
		)
		((and (<= 1025 param1) (<= param1 1030))
			; The six misc topics fill the grid's unused indexes 60..65.
			(return (- param1 965))
		)
		(else
			(return -1)
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0)
	; Has the character being asked already answered topic param1?
	(if (and global178 (!= (= temp0 (localproc_2 param1)) -1))
		(if (& [global296 temp0] (>> $8000 (- global178 1)))
			(return 1)
		)
	)
	(return 0)
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(backPage hide:)
	(morePage hide:)
	(DrawPic 851)
	(notebookList eachElementDo: 617 0)
	(Display {} dsRESTOREPIXELS local7)
	(= local7
		(Display
			@global136
			dsCOORD
			(- 160 (* 7 (StrLen @global136)))
			170
			dsFONT
			global119
			dsCOLOR
			global157
			dsSAVEPIXELS
		)
	)
	(for
		((= local2 (= temp0 (* (- local0 1) 8))))
		(and
			(< local2 (+ 8 temp0))
			(= temp1 (Memory memPEEK (+ local1 (* 2 local2))))
		)
		((++ local2))

		(if ((= temp2 (notebookList at: (mod local2 8))) respondsTo: 617)
			(temp2 display: (mod local2 8) temp1)
		)
	)
	(if (and (== (mod local2 8) 0) (Memory memPEEK (+ local1 (* 2 local2))))
		(morePage show:)
	)
)

(procedure (localproc_1 param1)
	(= local10 param1)
	(switch param1
		(1
			(peopleTab show: (if (> (peopleTab x:) 100) 1 else 0))
			(= local1 @global202)
		)
		(2
			(placesTab show: (if (> (placesTab x:) 100) 1 else 0))
			(= local1 @global220)
		)
		(3
			(thingsTab show: (if (> (thingsTab x:) 100) 1 else 0))
			(= local1 @global228)
		)
		(4
			(miscTab show: (if (> (miscTab x:) 100) 1 else 0))
			(= local1 @global263)
		)
	)
	(titlePage hide:)
	(= local0 1)
	(localproc_0)
)

(class NotebookItem of Obj
	(properties
		name {NotebookItem}
		subject 0
		x 0
		y 0
		nsLeft 0
		nsRight 0
		nsTop 0
		nsBottom 0
	)

	(method (init)
		(notebookList add: self)
		(super init:)
	)

	(method (display param1 param2 &tmp temp0 temp1 [temp2 40] temp42 temp43 temp44 temp45)
		(if (> param2 1088)
			(= temp45 (- param2 1088))
			(= temp42 857)
			(= temp43 (/ (- temp45 1) 16))
			(= temp44 (mod (- temp45 1) 16))
			(= subject (- param2 1024))
			(self posn: param1 temp42 temp43 temp44)
			(DrawCel temp42 temp43 temp44 x y)
		else
			(= subject param2)
			(= temp0 (/ subject 256))
			(= temp1 (mod subject 256))
			(self posn: param1)
			(Message msgGET 20 temp0 1 0 temp1 @temp2)
			(Display
				@temp2
				dsFONT
				10
				dsCOORD
				x
				y
				dsCOLOR
				(if (== local4 param2)
					global160
				else
					(if (localproc_3 param2) global154 else 0)
				)
				dsWIDTH
				100
			)
		)
	)

	(method (handleEvent param1 &tmp temp0)
		(cond
			((param1 claimed:)
				(return 1)
			)
			((and (& (param1 type:) $4000) (self onMe: param1))
				(param1 claimed: 1)
				(self doVerb: (param1 message:))
			)
		)
		(return (param1 claimed:))
	)

	(method (doVerb param1 &tmp [temp0 100] temp100 temp101)
		(switch param1
			(13
				(inNotebook doVerb: 13)
			)
			(4
				(if (< subject 256)
					(= local4 0)
					(if (< (StrLen @global136) 16)
						(Format @global136 {%s%c} @global136 subject)
						(Display {} dsRESTOREPIXELS local7)
						(= local7
							(Display
								@global136
								dsCOORD
								(- 160 (* 7 (StrLen @global136)))
								170
								dsFONT
								global119
								dsCOLOR
								global157
								dsSAVEPIXELS
							)
						)
					)
				else
					(if (== local4 subject)
						(inNotebook doVerb: 13)
						(return)
					)
					(Display {} dsRESTOREPIXELS local7)
					(= global136 0)
					(= temp100 (/ local4 256))
					(= temp101 (mod local4 256))
					(if
						(and
							local4
							(notebookList firstTrue: 96 oldOnePresent local4)
						)
						(Message msgGET 20 temp100 1 0 temp101 @temp0)
						(Display
							@temp0
							dsFONT
							10
							dsCOORD
							local5
							local6
							dsCOLOR
							(if (localproc_3 local4) global154 else 0)
							dsWIDTH
							100
						)
					)
					(= local4 subject)
					(= local5 x)
					(= local6 y)
					(= temp100 (/ local4 256))
					(= temp101 (mod local4 256))
					(Message msgGET 20 temp100 1 0 temp101 @temp0)
					(Display
						@temp0
						dsFONT
						10
						dsCOORD
						local5
						local6
						dsCOLOR
						global160
						dsWIDTH
						100
					)
				)
			)
		)
	)

	(method (onMe param1)
		(return
			(if
				(and
					(<= nsLeft (param1 x:))
					(<= (param1 x:) nsRight)
					(<= nsTop (param1 y:))
					(<= (param1 y:) nsBottom)
				)
				1
			else
				0
			)
		)
	)

	(method (posn param1 param2 param3 param4 &tmp temp0)
		(if (< subject 256)
			(= temp0 (if (< param1 4) 65 else 172))
			(= nsTop (+ (* (mod param1 4) 24) 43))
			(= nsLeft (+ temp0 (if (mod param1 2) 45 else 0)))
			(= nsBottom (+ (CelHigh param2 param3 param4) nsTop))
			(= nsRight (+ (CelWide param2 param3 param4) nsLeft))
			(= x nsLeft)
			(= y nsTop)
		else
			(= nsTop (+ (* (mod param1 4) 24) 43))
			(= nsLeft (if (< param1 4) 65 else 182))
			(= nsBottom (+ 5 nsTop))
			(= nsRight (+ 78 nsLeft))
			(= x nsLeft)
			(= y nsTop)
		)
	)
)

(instance oldOnePresent of Code
	(properties
		name {oldOnePresent}
	)

	(method (doit param1 param2)
		(return (== (param1 subject:) param2))
	)
)

(instance notebookList of EventHandler
	(properties
		name {notebookList}
	)
)

(instance titlePage of View
	(properties
		name {titlePage}
		x 156
		y 151
		modNum 20
		view 854
	)

	(method (initialize))

	(method (doVerb)
		(inNotebook doVerb: &rest)
	)
)

(instance morePage of View
	(properties
		name {morePage}
		x 237
		y 153
		modNum 20
		view 851
		loop 4
		cel 1
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(4
				(++ local0)
				(localproc_0)
				(backPage show:)
			)
			(else
				(inNotebook doVerb: param1)
			)
		)
	)
)

(instance backPage of View
	(properties
		name {backPage}
		x 85
		y 153
		modNum 20
		view 851
		loop 4
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(4
				(-- local0)
				(localproc_0)
				(if (== local0 1)
					(self hide:)
				else
					(self show:)
				)
			)
			(else
				(inNotebook doVerb: param1)
			)
		)
	)
)

(instance peopleTab of View
	(properties
		name {peopleTab}
		x 262
		y 58
		modNum 20
		view 851
		loop 1
		priority 5
		signal 16
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(4
				(localproc_1 1)
			)
			(else
				(inNotebook doVerb: param1)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
		else
			(placesTab setLoop: 1 x: 262)
			(thingsTab setLoop: 1 x: 262)
			(miscTab setLoop: 1 x: 262)
		)
	)
)

(instance placesTab of View
	(properties
		name {placesTab}
		x 262
		y 92
		modNum 20
		view 851
		loop 1
		cel 1
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(4
				(localproc_1 2)
			)
			(else
				(inNotebook doVerb: param1)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
			(peopleTab show: 1)
		else
			(thingsTab setLoop: 1 x: 262)
			(miscTab setLoop: 1 x: 262)
		)
	)
)

(instance thingsTab of View
	(properties
		name {thingsTab}
		x 262
		y 128
		modNum 20
		view 851
		loop 1
		cel 2
		priority 4
		signal 16
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(4
				(localproc_1 3)
			)
			(else
				(inNotebook doVerb: param1)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
			(placesTab show: 1)
		else
			(miscTab setLoop: 1 x: 262)
		)
	)
)

(instance miscTab of View
	(properties
		name {miscTab}
		x 262
		y 153
		modNum 20
		view 851
		loop 1
		cel 3
		priority 3
		signal 16
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(4
				(localproc_1 4)
			)
			(else
				(inNotebook doVerb: param1)
			)
		)
	)

	(method (show param1)
		(if (and argc param1)
			(self setLoop: 2 x: 59)
			(thingsTab show: 1)
		)
	)
)

(instance backUp of Feature
	(properties
		name {backUp}
		x 1
		y 1
		nsTop 175
		nsLeft 41
		nsBottom 189
		nsRight 279
	)

	(method (initialize))

	(method (doVerb param1)
		(switch param1
			(4
				(StrAt @global136 (- (StrLen @global136) 1) 0)
				(Display {} dsRESTOREPIXELS local7)
				(= local7
					(Display
						@global136
						dsCOORD
						(- 160 (* 7 (StrLen @global136)))
						170
						dsFONT
						global119
						dsCOLOR
						global157
						dsSAVEPIXELS
					)
				)
			)
			(else
				(inNotebook doVerb: param1)
			)
		)
	)
)

(instance inNotebook of Inset
	(properties
		name {inNotebook}
		picture 851
		modNum 20
	)

	(method (init)
		; PLAY-008: commit the topic chosen last time, which has been answered by now.
		(if (and global180 (== global181 gAct))
			(= [global296 global179] (| [global296 global179] (>> $8000 (- global180 1))))
		)
		(= global180 0)
		(if (= local9 (!= (((gTheIconBar at: 0) cursor:) view:) 6))
			(proc0_8 1)
		)
		(gGame handsOff:)
		(gTheIconBar disable: 7 enable: 2 0)
		(super init: &rest)
		(= local8 0)
		(= global136 0)
		(for ((= local2 0)) (< local2 8) ((++ local2))
			((NotebookItem new:) posn: local2 init:)
		)
		(backUp init:)
		(titlePage init: hide:)
		(morePage init: hide:)
		(backPage init: hide:)
		(peopleTab init: stopUpd:)
		(placesTab init: stopUpd:)
		(thingsTab init: stopUpd:)
		(miscTab init: stopUpd:)
		(localproc_1 (if local10 local10 else 1))
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gTheIconBar select: (gTheIconBar at: 2))
		(gGame setCursor: 2)
		(self doit:)
	)

	(method (doit &tmp temp0)
		(gPMouse joyInc: 2)
		(while (not local8)
			(Animate (gCast elements:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(gCast eachElementDo: 243)
			)
			(if script
				(script doit:)
			)
			(= gLastEvent (= temp0 (Event new:)))
			(temp0 localize:)
			(if (and gPMouse (gTheDoits contains: gPMouse))
				(gPMouse doit:)
			)
			(gUser canControl: 1)
			(MapKeyToDir temp0)
			(if (== (temp0 type:) 256)
				(temp0
					type: 4
					message: (if (& (temp0 modifiers:) $0003) 27 else 13)
					modifiers: 0
				)
			)
			(if (& (temp0 type:) $0040)
				(if (and (== (temp0 message:) 0) (& (temp0 type:) $0004))
					(gTheIconBar handleEvent: temp0)
				else
					(gPMouse handleEvent: temp0)
				)
			else
				(gTheIconBar handleEvent: temp0)
				(if (& (temp0 type:) $4000)
					(OnMeAndLowY init:)
					(gCast eachElementDo: 96 OnMeAndLowY temp0)
					(gFeatures eachElementDo: 96 OnMeAndLowY temp0)
					(cond
						((notebookList handleEvent: temp0))
						((OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: temp0)
						)
					)
				)
			)
			(temp0 dispose:)
		)
		(gPMouse joyInc: 5)
		(return local8)
	)

	(method (dispose)
		(notebookList dispose:)
		(super dispose: &rest)
		(Animate (gCast elements:) 0)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if local9
			(proc0_8 0)
		)
		(gGame handsOn: 1)
		(gTheIconBar enable: 7)
		(DisposeScript 20)
	)

	(method (doVerb param1 &tmp temp0)
		(switch param1
			(13
				(gGame setCursor: gWaitCursor)
				(if (not local4)
					(= local4 -1)
				)
				; PLAY-008: remember the topic for the character being asked.
				(if (and global178 (> local4 0) (!= (= temp0 (localproc_2 local4)) -1))
					(= global179 temp0)
					(= global180 global178)
					(= global181 gAct)
				)
				(= global178 0)
				(= local8 local4)
				(inNotebook dispose:)
			)
		)
	)
)
