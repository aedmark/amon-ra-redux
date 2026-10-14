;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 999)
(include sci.sh)
(use Main)
(use Print)

(public
	sign 0
	umod 1
	Min 2
	Max 3
	InRect 4
	OneOf 5
	WordAt 6
	Eval 7
)

(procedure (sign x)
	(return
		(if (< x 0)
			-1
		else
			(> x 0)
		)
	)
)

(procedure (umod n modN)
	(if (< (-= n (* modN (/ n modN))) 0)
		(+= n modN)
	)
	(return n)
)

(procedure (Min nums &tmp otherMin)
	(return
		(if (or (== argc 1) (< nums (= otherMin (Min &rest))))
			nums
		else
			otherMin
		)
	)
)

(procedure (Max nums &tmp otherMax)
	(return
		(if (or (== argc 1) (> nums (= otherMax (Max &rest))))
			nums
		else
			otherMax
		)
	)
)

(procedure (InRect lEdge tEdge rEdge bEdge ptxOrObj pty) ; UNUSED
	(return
		(and
			(<=
				lEdge
				(if (< argc 6)
					(ptxOrObj x:)
				else
					ptxOrObj
				)
				rEdge
			)
			(<=
				tEdge
				(if (< argc 6)
					(ptxOrObj y:)
				else
					pty
				)
				bEdge
			)
		)
	)
)

(procedure (OneOf what things &tmp i)
	(for ((= i 0)) (< i (- argc 1)) ((++ i))
		(if (== what [things i])
			(return (or what 1))
		)
	)
	(return 0)
)

(procedure (WordAt ptr n)
	(Memory memPEEK (+ ptr (* 2 n)))
)

(procedure (Eval obj sel)
	(obj sel: &rest)
)

(class Obj
	(properties
		name {Obj}
	)

	(method (new)
		(Clone self)
	)

	(method (init))

	(method (doit)
		(return self)
	)

	(method (dispose)
		(DisposeClone self)
	)

	(method (showStr param1)
		(StrCpy param1 name)
	)

	(method (showSelf &tmp [temp0 200])
		(Prints (self showStr: @temp0))
	)

	(method (perform param1)
		(param1 doit: self &rest)
	)

	(method (respondsTo param1)
		(RespondsTo self param1)
	)

	(method (isMemberOf param1)
		(return
			(or
				(== param1 self)
				(and
					(& (param1 -info-:) $8000)
					(not (& -info- $8000))
					(== -propDict- (param1 -propDict-:))
				)
			)
		)
	)

	(method (isKindOf param1 &tmp temp0)
		(return
			(or
				(and
					(== -propDict- (param1 -propDict-:))
					(== -classScript- (param1 -classScript-:))
				)
				(and
					(= temp0 (self -super-:))
					(IsObject temp0)
					(temp0 isKindOf: param1)
				)
			)
		)
	)

	(method (yourself)
		(return self)
	)
)

(class Code of Obj
	(properties
		name {Code}
	)

	(method (doit))
)

(class Collect of Obj
	(properties
		name {Collect}
		elements 0
		size 0
	)

	(method (doit)
		(self eachElementDo: 57 &rest)
	)

	(method (showStr param1)
		(Format param1 999 0 name size) ; "%s [Collection of size %d]"
	)

	(method (showSelf &tmp [temp0 40])
		(Prints (self showStr: @temp0))
		(self eachElementDo: 113)
	)

	(method (add param1 &tmp temp0 temp1 temp2)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= temp1 0)) (< temp1 argc) ((++ temp1))
			(if (not (self isDuplicate: [param1 temp1]))
				(AddToEnd elements (NewNode [param1 temp1] [param1 temp1]))
				(++ size)
			)
		)
		(return self)
	)

	(method (delete param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (DeleteKey elements [param1 temp0])
				(-- size)
			)
		)
		(return self)
	)

	(method (dispose)
		(if elements
			(self eachElementDo: 111)
			(DisposeList elements)
		)
		(= size (= elements 0))
		(super dispose:)
	)

	(method (first)
		(FirstNode elements)
	)

	(method (next param1)
		(NextNode param1)
	)

	(method (isEmpty)
		(return (or (== elements 0) (EmptyList elements)))
	)

	(method (contains param1)
		(FindKey elements param1)
	)

	(method (eachElementDo param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(if (not (IsObject (= temp2 (NodeValue temp0))))
				(return)
			)
			(temp2 param1: &rest)
		)
	)

	(method (firstTrue param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (temp2 param1: &rest)
				(return temp2)
			)
		)
		(return 0)
	)

	(method (allTrue param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(= temp2 (NodeValue temp0))
			(if (not (temp2 param1: &rest))
				(return 0)
			)
		)
		(return 1)
	)

	(method (release &tmp temp0 temp1)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 temp1))
			(= temp1 (NextNode temp0))
			(self delete: (NodeValue temp0))
		)
	)

	(method (isDuplicate)
		(return 0)
	)
)

(class List of Collect
	(properties
		name {List}
	)

	(method (showStr param1)
		(Format param1 999 1 name size) ; "%s [List of size %d]"
	)

	(method (at param1 &tmp temp0)
		(for
			((= temp0 (FirstNode elements)))
			(and param1 temp0)
			((= temp0 (NextNode temp0)))

			(-- param1)
		)
		(return
			(if temp0
				(NodeValue temp0)
			else
				0
			)
		)
	)

	(method (last)
		(LastNode elements)
	)

	(method (prev param1)
		(PrevNode param1)
	)

	(method (addToFront param1 &tmp temp0)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= temp0 (- argc 1))) (<= 0 temp0) ((-- temp0))
			(if (not (self isDuplicate: [param1 temp0]))
				(AddToFront elements (NewNode [param1 temp0] [param1 temp0]))
				(++ size)
			)
		)
		(return self)
	)

	(method (addToEnd param1 &tmp temp0)
		(if (not elements)
			(= elements (NewList))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (not (self isDuplicate: [param1 temp0]))
				(AddToEnd elements (NewNode [param1 temp0] [param1 temp0]))
				(++ size)
			)
		)
		(return self)
	)

	(method (addAfter param1 param2 &tmp temp0 temp1 temp2)
		(if (= temp2 (FindKey elements param1))
			(-- argc)
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(if (not (self isDuplicate: [param2 temp0]))
					(= temp2
						(AddAfter
							elements
							temp2
							(NewNode [param2 temp0] [param2 temp0])
						)
					)
					(++ size)
				)
			)
		)
		(return self)
	)

	(method (indexOf param1 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 (FirstNode elements))) temp1 ((= temp1 (NextNode temp1)))
			(if (== param1 (NodeValue temp1))
				(return temp0)
			)
			(++ temp0)
		)
		(return -1)
	)
)

(class Set of List
	(properties
		name {Set}
	)

	(method (showStr param1)
		(Format param1 999 2 name size) ; "%s [Set of size %d]"
	)

	(method (isDuplicate param1)
		(self contains: param1)
	)
)

(class EventHandler of Set
	(properties
		name {EventHandler}
	)

	(method (handleEvent param1 &tmp temp0 temp1 temp2)
		(for
			((= temp0 (FirstNode elements)))
			(and temp0 (not (param1 claimed:)))
			((= temp0 temp1))

			(= temp1 (NextNode temp0))
			(breakif (not (IsObject (= temp2 (NodeValue temp0)))))
			(temp2 handleEvent: param1)
		)
		(param1 claimed:)
	)
)

(class Script of Obj
	(properties
		name {Script}
		client 0
		state -1
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
		(cond
			(cycles
				(if (not (-- cycles))
					(self cue:)
				)
			)
			(seconds
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= lastSeconds temp0)
					(= lastSeconds temp0)
					(if (not (-- seconds))
						(self cue:)
					)
				)
			)
			((and ticks (<= (-= ticks (Abs (- gGameTime lastTicks))) 0))
				(= ticks 0)
				(self cue:)
			)
		)
		(= lastTicks gGameTime)
	)

	(method (init param1 param2 param3)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
				)
			)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (dispose &tmp temp0)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose:)
		)
		(if (IsObject client)
			(client
				script:
					(= temp0
						(cond
							((IsObject next) next)
							(next
								(ScriptID next)
							)
						)
					)
			)
			(cond
				((not temp0) 0)
				((== gNewRoomNum gCurRoomNum)
					(temp0 init: client)
				)
				(else
					(temp0 dispose:)
				)
			)
		)
		(if (and (IsObject caller) (== gNewRoomNum gCurRoomNum))
			(caller cue: register)
		)
		(= script (= timer (= client (= next (= caller 0)))))
		(super dispose:)
	)

	(method (changeState param1)
		(= state param1)
	)

	(method (cue)
		(if client
			(self changeState: (+ state 1) &rest)
		)
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (handleEvent param1)
		(if script
			(script handleEvent: param1)
		)
		(param1 claimed:)
	)
)

(class Event of Obj
	(properties
		name {Event}
		type 0
		message 0
		modifiers 0
		y 0
		x 0
		claimed 0
		port 0
	)

	(method (new param1 &tmp temp0)
		(= temp0 (super new:))
		(GetEvent (if argc param1 else 32767) temp0)
		(return temp0)
	)

	(method (localize &tmp temp0)
		(if (not (& type $4000))
			(= temp0 (GetPort))
			(cond
				((not port)
					(GlobalToLocal self)
				)
				((!= port temp0)
					(SetPort port)
					(LocalToGlobal self)
					(SetPort temp0)
					(GlobalToLocal self)
				)
			)
			(= port temp0)
		)
		(return self)
	)

	(method (globalize &tmp temp0)
		(if (not (& type $4000))
			(= temp0 (GetPort))
			(cond
				((== port temp0)
					(LocalToGlobal self)
				)
				(port
					(SetPort port)
					(LocalToGlobal self)
					(SetPort temp0)
				)
			)
			(= port 0)
		)
		(return self)
	)
)

(class Cursor of Obj
	(properties
		name {Cursor}
		view 0
		loop 0
		cel 0
		x 0
		y 0
		hotSpotX 0
		hotSpotY 0
		hidden 0
	)

	(method (init)
		(if (or hotSpotX hotSpotY)
			(SetCursor view loop cel hotSpotX hotSpotY)
		else
			(SetCursor view loop cel)
		)
	)

	(method (posn param1 param2)
		(SetCursor param1 param2)
	)

	(method (posnHotSpot param1 param2)
		(= hotSpotX param1)
		(= hotSpotY param2)
		(self init:)
	)

	(method (setLoop param1)
		(= loop param1)
		(self init:)
	)

	(method (setCel param1)
		(= cel param1)
		(self init:)
	)

	(method (showCursor param1)
		(if argc
			(SetCursor param1)
		)
	)
)
