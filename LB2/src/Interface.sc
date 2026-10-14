;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 255)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	StillDown 0
	GetNumber 1
	MousedOn 2
)

(procedure (StillDown &tmp event ret)
	(= ret (!= ((= event (Event new:)) type:) 2))
	(event dispose:)
	(return ret)
)

(procedure (GetNumber string default &tmp [theLine 40]) ; UNUSED
	(= theLine 0)
	(if (> argc 1)
		(Format @theLine {%d} default)
	)
	(return
		(if (GetInput @theLine 5 string)
			(ReadNumber @theLine)
		else
			-1
		)
	)
)

(procedure (MousedOn obj event) ; UNUSED
	(return
		(if
			(and
				(< (obj nsLeft:) (event x:))
				(< (event x:) (obj nsRight:))
				(< (obj nsTop:) (event y:))
			)
			(< (event y:) (obj nsBottom:))
		else
			0
		)
	)
)

(class DItem of Obj
	(properties
		name 0
		type 0
		state 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		key 0
		said 0
		value 0
	)

	(method (doit)
		(return value)
	)

	(method (enable param1)
		(if param1
			(|= state $0001)
		else
			(&= state $fffe)
		)
	)

	(method (select param1)
		(if param1
			(|= state $0008)
		else
			(&= state $fff7)
		)
		(self draw:)
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2)
		(if (param1 claimed:)
			(return 0)
		)
		(= temp0 0)
		(if
			(and
				(& state $0001)
				(or
					(and (== (= temp1 (param1 type:)) 128) (Said said))
					(and (== temp1 4) (== (param1 message:) key))
					(and (== temp1 1) (self check: param1))
				)
			)
			(param1 claimed: 1)
			(= temp0 (self track: param1))
		)
		(return temp0)
	)

	(method (check param1)
		(return
			(if
				(and
					(>= (param1 x:) nsLeft)
					(>= (param1 y:) nsTop)
					(< (param1 x:) nsRight)
				)
				(< (param1 y:) nsBottom)
			else
				0
			)
		)
	)

	(method (track param1 &tmp temp0 temp1)
		(if (== 1 (param1 type:))
			(= temp1 0)
			(while 1
				((= param1 (Event new: -32768)) localize:)
				(if (!= (= temp0 (self check: param1)) temp1)
					(HiliteControl self)
					(= temp1 temp0)
				)
				(param1 dispose:)
				(if (not (StillDown))
					(break)
				)
			)
			(if temp0
				(HiliteControl self)
			)
			(return temp0)
		else
			(return self)
		)
	)

	(method (setSize))

	(method (move param1 param2)
		(+= nsRight param1)
		(+= nsLeft param1)
		(+= nsTop param2)
		(+= nsBottom param2)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)

	(method (draw)
		(DrawControl self)
	)

	(method (isType param1)
		(return (== type param1))
	)

	(method (checkState param1)
		(return (& state param1))
	)

	(method (cycle))
)

(class DText of DItem
	(properties
		name {DText}
		type 2
		text 0
		font 1
		mode 0
	)

	(method (new &tmp temp0)
		((super new:) font: gUserFont yourself:)
	)

	(method (dispose param1)
		(if (and text (or (not argc) (not param1)))
			(Memory memFREE (self text:))
		)
		(super dispose:)
	)

	(method (setSize param1 &tmp [temp0 2] temp2 temp3)
		(TextSize
			@temp0
			text
			font
			(if argc param1 else 0)
			{ \n---------- \n}
		)
		(= nsBottom (+ nsTop temp2))
		(= nsRight (+ nsLeft temp3))
	)
)

(class Dialog of List
	(properties
		name {Dialog}
		text 0
		font 0
		window 0
		theItem 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		time 0
		caller 0
		seconds 0
		lastSeconds 0
		eatTheMice 0
		lastTicks 0
	)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp2 0)
		(self eachElementDo: 110)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: 185 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= eatTheMice gEatMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= temp1 0)
		(while (not temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self eachElementDo: 186)
			(= temp0 ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (temp0 type:) 1)
					(temp0 type: 0)
				)
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(= temp1 (self handleEvent: temp0))
			(temp0 dispose:)
			(if (self check:)
				(break)
			)
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl theItem 0)
				(break)
			)
			(Wait 1)
		)
		(return temp1)
	)

	(method (dispose &tmp temp0)
		(self eachElementDo: 111 release:)
		(if (== self gModelessDialog)
			(SetPort gModelessPort)
			(= gModelessDialog 0)
			(= gModelessPort 0)
		)
		(if window
			(window dispose:)
			(= window 0)
		)
		(= theItem 0)
		(= temp0 caller)
		(super dispose:)
		(if temp0
			(temp0 cue:)
		)
	)

	(method (open param1 param2)
		(if (and (PicNotValid) gCast)
			(Animate (gCast elements:) 0)
		)
		(= window (window new:))
		(window
			top: nsTop
			left: nsLeft
			bottom: nsBottom
			right: nsRight
			title: text
			type: param1
			priority: param2
			open:
		)
		(= seconds time)
		(self draw:)
	)

	(method (draw)
		(self eachElementDo: 80)
	)

	(method (advance &tmp temp0 temp1)
		(if theItem
			(theItem select: 0)
			(= temp1 (self contains: theItem))
			(while 1
				(if (not (= temp1 (self next: temp1)))
					(= temp1 (self first:))
				)
				(= theItem (NodeValue temp1))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(theItem nsLeft:)
						(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
					)
					(- (theItem nsBottom:) 3)
			)
		)
	)

	(method (retreat &tmp temp0 temp1)
		(if theItem
			(theItem select: 0)
			(= temp1 (self contains: theItem))
			(while 1
				(if (not (= temp1 (self prev: temp1)))
					(= temp1 (self last:))
				)
				(= theItem (NodeValue temp1))
				(if (& (theItem state:) $0001)
					(break)
				)
			)
			(theItem select: 1)
			(gGame
				setCursor:
					gTheCursor
					1
					(+
						(theItem nsLeft:)
						(/ (- (theItem nsRight:) (theItem nsLeft:)) 2)
					)
					(- (theItem nsBottom:) 3)
			)
		)
	)

	(method (move param1 param2)
		(+= nsRight param1)
		(+= nsLeft param1)
		(+= nsTop param2)
		(+= nsBottom param2)
	)

	(method (moveTo param1 param2)
		(self move: (- param1 nsLeft) (- param2 nsTop))
	)

	(method (center)
		(self
			moveTo:
				(+
					(window brLeft:)
					(/
						(-
							(- (window brRight:) (window brLeft:))
							(- nsRight nsLeft)
						)
						2
					)
				)
				(+
					(window brTop:)
					(/
						(-
							(- (window brBottom:) (window brTop:))
							(- nsBottom nsTop)
						)
						2
					)
				)
		)
	)

	(method (setSize &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if text
			(TextSize @temp2 text font -1 0)
			(= nsTop temp2)
			(= nsLeft temp3)
			(= nsBottom temp4)
			(= nsRight temp5)
		else
			(= nsRight (= nsBottom (= nsLeft (= nsTop 0))))
		)
		(for ((= temp0 (self first:))) temp0 ((= temp0 (self next: temp0)))
			(if (< ((= temp1 (NodeValue temp0)) nsLeft:) nsLeft)
				(= nsLeft (temp1 nsLeft:))
			)
			(if (< (temp1 nsTop:) nsTop)
				(= nsTop (temp1 nsTop:))
			)
			(if (> (temp1 nsRight:) nsRight)
				(= nsRight (temp1 nsRight:))
			)
			(if (> (temp1 nsBottom:) nsBottom)
				(= nsBottom (temp1 nsBottom:))
			)
		)
		(+= nsRight 4)
		(+= nsBottom 4)
		(self moveTo: 0 0)
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2)
		(if (& (param1 type:) $0040)
			(switch (param1 message:)
				(5
					(param1 type: 4 message: 20480)
				)
				(1
					(param1 type: 4 message: 18432)
				)
				(7
					(param1 type: 4 message: 19200)
				)
				(3
					(param1 type: 4 message: 19712)
				)
			)
		)
		(= temp1 (param1 type:))
		(= temp2 (param1 message:))
		(if (= temp0 (self firstTrue: 133 param1))
			(EditControl theItem 0)
			(if (not (temp0 checkState: 2))
				(if theItem
					(theItem select: 0)
				)
				((= theItem temp0) select: 1)
				(temp0 doit:)
				(= temp0 0)
			else
				(return temp0)
			)
		else
			(= temp0 0)
			(cond
				(
					(and
						(or (== temp1 256) (and (== temp1 4) (== temp2 13)))
						theItem
						(theItem checkState: 1)
					)
					(= temp0 theItem)
					(EditControl theItem 0)
					(param1 claimed: 1)
				)
				((and (== temp1 4) (== temp2 27))
					(param1 claimed: 1)
					(= temp0 -1)
				)
				(
					(and
						(not (self firstTrue: 185 1))
						(or
							(and (== temp1 4) (== temp2 13))
							(OneOf temp1 1 256)
						)
					)
					(param1 claimed: 1)
					(= temp0 -2)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== temp1 4)
						(== temp2 19712)
					)
					(if (>= (theItem cursor:) (StrLen (theItem text:)))
						(self advance:)
					else
						(EditControl theItem param1)
					)
				)
				(
					(and
						(IsObject theItem)
						(theItem isType: 3)
						(== temp1 4)
						(== temp2 19200)
					)
					(if (<= (theItem cursor:) 0)
						(self retreat:)
					else
						(EditControl theItem param1)
					)
				)
				((and (== temp1 4) (OneOf temp2 9 19712 20480))
					(param1 claimed: 1)
					(self advance:)
				)
				((and (== temp1 4) (OneOf temp2 3840 19200 18432))
					(param1 claimed: 1)
					(self retreat:)
				)
				(else
					(EditControl theItem param1)
				)
			)
		)
		(return temp0)
	)

	(method (check &tmp temp0)
		(if (and seconds (!= lastSeconds (= temp0 (GetTime 1)))) ; SysTime12
			(= lastSeconds temp0)
			(return (not (-- seconds)))
		else
			0
		)
	)
)
