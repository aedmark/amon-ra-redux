;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 928)
(include sci.sh)
(use Main)
(use Print)
(use RandCycle)
(use Motion)
(use Actor)
(use System)

(class RTRandCycle of RandCycle
	(properties
		name {RTRandCycle}
	)

	(method (doit &tmp temp0)
		(if (or (> count (= temp0 (GetTime))) (== count -1))
			(if (> (- temp0 cycleCnt) (client cycleSpeed:))
				(client cel: (self nextCel:))
				(= cycleCnt (GetTime))
			)
		else
			(client cel: 0)
			(self cycleDone:)
		)
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(client cel: 0)
		(= cycleCnt (GetTime))
		(if (>= argc 2)
			(if (!= param2 -1)
				(= count (+ (GetTime) param2))
			else
				(= count -1)
			)
			(if (>= argc 3)
				(= caller param3)
			)
		else
			(= count -1)
		)
	)
)

(class Blink of Cycle
	(properties
		name {Blink}
		waitCount 0
		lastCount 0
		waitMin 0
		waitMax 0
	)

	(method (init param1 param2)
		(if argc
			(= waitMin (/ param2 2))
			(= waitMax (+ param2 waitMin))
			(super init: param1)
		else
			(super init:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(waitCount
				(if (> (- gGameTime waitCount) 0)
					(= waitCount 0)
					(self init:)
				)
			)
			((or (> (= temp0 (self nextCel:)) (client lastCel:)) (< temp0 0))
				(= cycleDir (- cycleDir))
				(self cycleDone:)
			)
			(else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(if (== cycleDir -1)
			(self init:)
		else
			(= waitCount (+ (Random waitMin waitMax) gGameTime))
		)
	)
)

(class Narrator of Prop
	(properties
		name {Narrator}
		x -1
		y -1
		caller 0
		disposeWhenDone 1
		ticks 0
		talkWidth 0
		keepWindow 0
		modeless 0
		font 0
		cueVal 0
		initialized 0
		showTitle 0
		color 0
		back 7
		curVolume 0
		saveCursor 0
	)

	(method (init)
		(if global83
			(self curVolume: (gGame masterVolume:))
			(if (>= (gGame masterVolume:) 4)
				(gGame masterVolume: (- curVolume 4))
			)
			(if (not modeless)
				(= saveCursor (gGame setCursor: gWaitCursor 1))
			)
		)
		(= initialized 1)
	)

	(method (say param1 param2 param3 param4 param5 param6 &tmp [temp0 4])
		(gTheIconBar disable:)
		(if (and (> argc 5) param6)
			(= modNum param6)
		else
			(= modNum -1)
		)
		(if (not initialized)
			(self init:)
		)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(= caller (if (and (> argc 4) param5) param5 else 0))
		(if (& gMsgType $0002)
			(self startAudio:)
		)
		(if (& gMsgType $0001)
			(self startText:)
		)
		(cond
			(modeless
				(gMouseDownHandler addToFront: self)
				(gKeyDownHandler addToFront: self)
				(gTheDoits add: self)
			)
			((IsObject gFastCast)
				(gFastCast add: self)
			)
			(else
				((= gFastCast (EventHandler new:))
					name: {fastCast}
					add: self
				)
			)
		)
		(+= ticks (+ 60 gGameTime))
		(return 1)
	)

	(method (startText &tmp [temp0 1000] temp1000)
		(Message msgNEXT @temp0)
		(if (not (& gMsgType $0002))
			(= ticks (Max 240 (* 8 (= temp1000 (StrLen @temp0)))))
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(self display: @temp0)
		(return temp1000)
	)

	(method (display param1 &tmp temp0 temp1)
		(if (> (+ x talkWidth) 318)
			(= temp0 (- 318 x))
		else
			(= temp0 talkWidth)
		)
		((= temp1 (gSystemWindow new:)) color: color back: back)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= saveCursor gTheCursor)
			(gGame setCursor: 996)
		else
			(= saveCursor 0)
		)
		(Print
			window: temp1
			posn: x y
			font: font
			width: temp0
			title: (if showTitle name else 0)
			addText: param1
			modeless: 1
			init:
		)
	)

	(method (startAudio))

	(method (doit)
		(if
			(and
				(!= ticks -1)
				(> (- gGameTime ticks) 0)
				(if global83
					(== (DoAudio audPOSITION) -1)
				else
					1
				)
				(not keepWindow)
			)
			(self dispose: disposeWhenDone)
			(return 0)
		)
		(return 1)
	)

	(method (handleEvent param1)
		(cond
			((param1 claimed:))
			((== ticks -1)
				(return 0)
			)
			(else
				(switch (param1 type:)
					(256
						(= cueVal 0)
					)
					(1
						(= cueVal (& (param1 modifiers:) $0003))
					)
					(4
						(= cueVal (== (param1 message:) 27))
					)
				)
				(if
					(or
						(& (param1 type:) $4101)
						(and
							(& (param1 type:) $0004)
							(OneOf (param1 message:) 13 27)
						)
					)
					(param1 claimed: 1)
					(self dispose: disposeWhenDone)
				)
			)
		)
	)

	(method (dispose param1)
		(= ticks -1)
		(if (or (not argc) param1)
			(cond
				(modeless
					(gKeyDownHandler delete: self)
					(gMouseDownHandler delete: self)
					(gTheDoits delete: self)
				)
				((and gFastCast (gFastCast contains: self))
					(gFastCast delete: self)
					(if (gFastCast isEmpty:)
						(gFastCast dispose:)
						(= gFastCast 0)
					)
				)
			)
			(if global83
				(DoAudio audSTOP)
			)
			(= modNum -1)
			(= initialized 0)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(if global83
			(gGame masterVolume: curVolume)
		)
		(if (and saveCursor (not (HaveMouse)))
			(gGame setCursor: saveCursor)
		)
		(if caller
			(caller cue: cueVal)
		)
		(DisposeClone self)
	)
)

(class Talker of Narrator
	(properties
		name {Talker}
		talkWidth 318
		bust 0
		eyes 0
		mouth 0
		viewInPrint 0
		textX 0
		textY 0
		useFrame 0
		blinkSpeed 100
	)

	(method (init param1 param2 param3)
		(if argc
			(= bust param1)
			(if (>= argc 2)
				(= eyes param2)
				(if (>= argc 3)
					(= mouth param3)
				)
			)
		)
		(self setSize:)
		(super init:)
	)

	(method (setSize)
		(= nsLeft x)
		(= nsTop y)
		(= nsRight
			(+
				nsLeft
				(Max
					(if view
						(CelWide view loop cel)
					else
						0
					)
					(and
						(IsObject bust)
						(+
							(bust nsLeft:)
							(CelWide
								(bust view:)
								(bust loop:)
								(bust cel:)
							)
						)
					)
					(and
						(IsObject eyes)
						(+
							(eyes nsLeft:)
							(CelWide
								(eyes view:)
								(eyes loop:)
								(eyes cel:)
							)
						)
					)
					(and
						(IsObject mouth)
						(+
							(mouth nsLeft:)
							(CelWide
								(mouth view:)
								(mouth loop:)
								(mouth cel:)
							)
						)
					)
				)
			)
		)
		(= nsBottom
			(+
				nsTop
				(Max
					(if view
						(CelHigh view loop cel)
					else
						0
					)
					(and
						(IsObject bust)
						(+
							(bust nsTop:)
							(CelHigh
								(bust view:)
								(bust loop:)
								(bust cel:)
							)
						)
					)
					(and
						(IsObject eyes)
						(+
							(eyes nsTop:)
							(CelHigh
								(eyes view:)
								(eyes loop:)
								(eyes cel:)
							)
						)
					)
					(and
						(IsObject mouth)
						(+
							(mouth nsTop:)
							(CelHigh
								(mouth view:)
								(mouth loop:)
								(mouth cel:)
							)
						)
					)
				)
			)
		)
	)

	(method (show &tmp temp0)
		(if (not underBits)
			(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		)
		(= temp0 (PicNotValid))
		(PicNotValid 1)
		(if bust
			(DrawCel
				(bust view:)
				(bust loop:)
				(bust cel:)
				(+ (bust nsLeft:) nsLeft)
				(+ (bust nsTop:) nsTop)
				-1
			)
		)
		(if eyes
			(DrawCel
				(eyes view:)
				(eyes loop:)
				(eyes cel:)
				(+ (eyes nsLeft:) nsLeft)
				(+ (eyes nsTop:) nsTop)
				-1
			)
		)
		(if mouth
			(DrawCel
				(mouth view:)
				(mouth loop:)
				(mouth cel:)
				(+ (mouth nsLeft:) nsLeft)
				(+ (mouth nsTop:) nsTop)
				-1
			)
		)
		(DrawCel view loop cel nsLeft nsTop -1)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid temp0)
	)

	(method (say)
		(if (or (== modNum -1) (and (> view 0) (not underBits)))
			(self init:)
			(if (== modNum -1)
				(= modNum gCurRoomNum)
			)
		)
		(super say: &rest)
	)

	(method (startText &tmp temp0)
		(if (not viewInPrint)
			(self show:)
		)
		(= temp0 (super startText: &rest))
		(if mouth
			(mouth setCycle: RTRandCycle (* 4 temp0))
		)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (display param1 &tmp temp0 temp1 temp2 temp3)
		((= temp3 (gSystemWindow new:)) color: color back: back)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= saveCursor gTheCursor)
			(gGame setCursor: 996)
		else
			(= saveCursor 0)
		)
		(if viewInPrint
			(= temp0
				(if useFrame
					loop
				else
					(bust loop:)
				)
			)
			(Print
				window: temp3
				posn: x y
				modeless: 1
				font: font
				width: temp1
				title: (if showTitle name else 0)
				addText: param1
				addIcon: view temp0 cel 0 0
				init:
			)
		else
			(if (not (+ textX textY))
				(= textX (+ (- nsRight nsLeft) 5))
			)
			(if (> (+ (= temp2 (+ nsLeft textX)) talkWidth) 318)
				(= temp1 (- 318 temp2))
			else
				(= temp1 talkWidth)
			)
			(Print
				window: temp3
				posn: (+ x textX) (+ y textY)
				modeless: 1
				font: font
				width: temp1
				title: (if showTitle name else 0)
				addText: param1
				init:
			)
		)
	)

	(method (startAudio param1)
		(self show:)
		(super startAudio: param1 &rest)
		(if (and eyes (not (eyes cycler:)))
			(eyes setCycle: Blink blinkSpeed)
		)
	)

	(method (cycle param1 &tmp temp0 [temp1 100])
		(if (and param1 (param1 cycler:))
			(= temp0 (param1 cel:))
			((param1 cycler:) doit:)
			(if (!= temp0 (param1 cel:))
				(DrawCel
					(param1 view:)
					(param1 loop:)
					(param1 cel:)
					(+ (param1 nsLeft:) nsLeft)
					(+ (param1 nsTop:) nsTop)
					-1
				)
				(param1
					nsRight:
						(+
							(param1 nsLeft:)
							(CelWide
								(param1 view:)
								(param1 loop:)
								(param1 cel:)
							)
						)
				)
				(param1
					nsBottom:
						(+
							(param1 nsTop:)
							(CelHigh
								(param1 view:)
								(param1 loop:)
								(param1 cel:)
							)
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (param1 nsTop:) nsTop)
					(+ (param1 nsLeft:) nsLeft)
					(+ (param1 nsBottom:) nsTop)
					(+ (param1 nsRight:) nsLeft)
					1
				)
			)
		)
	)

	(method (doit)
		(if (and (super doit:) mouth)
			(self cycle: mouth)
		)
		(if eyes
			(self cycle: eyes)
		)
	)

	(method (hide)
		(Graph grRESTORE_BOX underBits)
		(= underBits 0)
		(Graph grREDRAW_BOX nsTop nsLeft nsBottom nsRight)
		(gTheIconBar enable:)
	)

	(method (dispose param1)
		(if (and mouth underBits)
			(mouth cel: 0)
			(DrawCel
				(mouth view:)
				(mouth loop:)
				0
				(+ (mouth nsLeft:) nsLeft)
				(+ (mouth nsTop:) nsTop)
				-1
			)
		)
		(if (and mouth (mouth cycler:))
			(if ((mouth cycler:) respondsTo: 145)
				((mouth cycler:) cue:)
			)
			(mouth setCycle: 0)
		)
		(if (or (not argc) param1)
			(if (and eyes underBits)
				(eyes setCycle: 0 cel: 0)
				(DrawCel
					(eyes view:)
					(eyes loop:)
					0
					(+ (eyes nsLeft:) nsLeft)
					(+ (eyes nsTop:) nsTop)
					-1
				)
			)
			(self hide:)
		)
		(super dispose: param1)
	)
)
